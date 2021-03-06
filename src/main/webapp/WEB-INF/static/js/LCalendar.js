!function (t) {
    var e = {};

    function i(a) {
        if (e[a]) return e[a].exports;
        var r = e[a] = {i: a, l: !1, exports: {}};
        return t[a].call(r.exports, r, r.exports, i), r.l = !0, r.exports
    }

    i.m = t, i.c = e, i.d = function (t, e, a) {
        i.o(t, e) || Object.defineProperty(t, e, {enumerable: !0, get: a})
    }, i.r = function (t) {
        "undefined" != typeof Symbol && Symbol.toStringTag && Object.defineProperty(t, Symbol.toStringTag, {value: "Module"}), Object.defineProperty(t, "__esModule", {value: !0})
    }, i.t = function (t, e) {
        if (1 & e && (t = i(t)), 8 & e) return t;
        if (4 & e && "object" == typeof t && t && t.__esModule) return t;
        var a = Object.create(null);
        if (i.r(a), Object.defineProperty(a, "default", {
            enumerable: !0,
            value: t
        }), 2 & e && "string" != typeof t) for (var r in t) i.d(a, r, function (e) {
            return t[e]
        }.bind(null, r));
        return a
    }, i.n = function (t) {
        var e = t && t.__esModule ? function () {
            return t.default
        } : function () {
            return t
        };
        return i.d(e, "a", e), e
    }, i.o = function (t, e) {
        return Object.prototype.hasOwnProperty.call(t, e)
    }, i.p = "", i(i.s = 0)
}([function (t, e, i) {
    t.exports = i(1)
}, function (t, e, i) {
    "use strict";
    i.r(e);

    class a {
        constructor() {
            this.gearDate, this.minY = 1900, this.minM = 1, this.minD = 1, this.maxY = 2099, this.maxM = 12, this.maxD = 31
        }

        init(t) {
            if (this.type = t.type, this.trigger = document.querySelector(t.trigger), null != this.trigger.getAttribute("data-lcalendar")) {
                let t = this.trigger.getAttribute("data-lcalendar").split(","), e = t[0].split("-");
                this.minY = ~~e[0], this.minM = ~~e[1], this.minD = ~~e[2];
                let i = t[1].split("-");
                this.maxY = ~~i[0], this.maxM = ~~i[1], this.maxD = ~~i[2]
            }
            if (t.minDate) {
                let e = t.minDate.split("-");
                this.minY = ~~e[0], this.minM = ~~e[1], this.minD = ~~e[2]
            }
            if (t.maxDate) {
                let e = t.maxDate.split("-");
                this.maxY = ~~e[0], this.maxM = ~~e[1], this.maxD = ~~e[2]
            }
            this.bindEvent(this.type)
        }

        calcDays(t, e) {
            return 1 == e ? (t += this.minY) % 4 == 0 && t % 100 != 0 || t % 400 == 0 && t % 4e3 != 0 ? 29 : 28 : 3 == e || 5 == e || 8 == e || 10 == e ? 30 : 31
        }

        defaultValueInit() {
            let t = new Date, e = {yy: -1, mm: t.getMonth(), dd: t.getDate() - 1, hh: t.getHours(), mi: t.getMinutes()};
            if (/^\d{4}-\d{1,2}-\d{1,2}\s\d{2}:\d{2}$/.test(this.trigger.value)) {
                let [t, i, a, r, s] = this.trigger.value.match(/(^|-|\s|:)\d{1,4}/g);
                e.yy = t - this.minY, e.mm = i.replace(/-/g, "") - 1, e.dd = a.replace(/-/g, "") - 1, e.hh = ~~r.replace(/\s0?/g, ""), e.mi = ~~s.replace(/:0?/g, "")
            } else if (/^\d{4}-\d{1,2}-\d{1,2}$/.test(this.trigger.value)) {
                const [t, i, a] = this.trigger.value.match(/(^|-)\d{1,4}/g);
                e.yy = t - this.minY, e.mm = i.replace(/-/g, "") - 1, e.dd = a.replace(/-/g, "") - 1
            } else if (/^\d{4}-\d{1,2}$/.test(this.trigger.value)) {
                let [t, i] = this.trigger.value.match(/(^|-)\d{1,4}/g);
                e.yy = t - this.minY, e.mm = i.replace(/-/g, "") - 1
            } else if (/^\d{2}:\d{2}$/.test(this.trigger.value)) {
                let [t, i] = this.trigger.value.match(/(^|:)\d{2}/g);
                e.hh = ~~t.replace(/^0?/g, ""), e.mi = ~~i.replace(/:0?/g, "")
            }
            if (this.gearDate.querySelector(".date_yy")) {
                if (e.yy < 0) {
                    const i = t.getFullYear(), a = i - this.minY, r = i - this.maxY;
                    if (a <= 0) {
                        e.yy = 0;
                        const t = this.minM - 1, i = this.minD - 1;
                        e.mm <= t && (e.mm = t, e.dd = i)
                    } else if (r >= 0) {
                        e.yy = a;
                        const t = this.maxM - 1, i = this.maxD - 1;
                        e.mm >= t && (e.mm = t, e.dd = i)
                    } else e.yy = a
                }
                this.gearDate.querySelector(".date_yy").setAttribute("val", e.yy), this.gearDate.querySelector(".date_mm").setAttribute("val", e.mm), this.gearDate.querySelector(".date_dd") && this.gearDate.querySelector(".date_dd").setAttribute("val", e.dd), this.setDateGearTooth()
            }
            this.gearDate.querySelector(".time_hh") && this.gearDate.querySelector(".time_mm") && (this.gearDate.querySelector(".time_hh").setAttribute("val", e.hh), this.gearDate.querySelector(".time_mm").setAttribute("val", e.mi), this.setTimeGearTooth())
        }

        setTimeGearTooth() {
            let t = this.gearDate.querySelector(".time_hh");
            if (!t || !t.getAttribute("val")) return;
            {
                let e = "", i = parseInt(t.getAttribute("val"));
                for (let t = 0; t <= 23; t++) e += "<div class='tooth'>" + t + "</div>";
                t.innerHTML = e, t.style["-webkit-transform"] = "translate3d(0," + (8 - 2 * i) + "em,0)", t.setAttribute("top", 8 - 2 * i + "em")
            }
            let e = this.gearDate.querySelector(".time_mm");
            if (e && e.getAttribute("val")) {
                let t = "", i = parseInt(e.getAttribute("val"));
                for (let e = 0; e <= 59; e++) t += "<div class='tooth'>" + e + "</div>";
                e.innerHTML = t, e.style["-webkit-transform"] = "translate3d(0," + (8 - 2 * i) + "em,0)", e.setAttribute("top", 8 - 2 * i + "em")
            }
        }

        setDateGearTooth() {
            let t = (new Date).getFullYear(), e = this.maxY - this.minY + 1,
                i = this.gearDate.querySelector(".date_yy"), a = "";
            if (!i || !i.getAttribute("val")) return;
            let r = parseInt(i.getAttribute("val"));
            for (let t = 0; t <= e - 1; t++) a += "<div class='tooth'>" + (this.minY + t) + "</div>";
            i.innerHTML = a;
            let s = Math.floor(parseFloat(i.getAttribute("top")));
            if (isNaN(s)) {
                let a = 8 - 2 * (e - 1), s = Math.abs(a - 8) / 2;
                this.maxY < t ? r > s && (r = s) : this.minY > t && r > s && (r = s), i.style["-webkit-transform"] = "translate3d(0," + (8 - 2 * r) + "em,0)", i.setAttribute("top", 8 - 2 * r + "em")
            } else {
                s % 2 == 0 ? s = s : s += 1, s > 8 && (s = 8);
                let t = 8 - 2 * (e - 1);
                s < t && (s = t), i.style["-webkit-transform"] = "translate3d(0," + s + "em,0)", i.setAttribute("top", s + "em"), r = Math.abs(s - 8) / 2, i.setAttribute("val", r)
            }
            let n = this.gearDate.querySelector(".date_mm");
            if (!n || !n.getAttribute("val")) return;
            a = "";
            let d = parseInt(n.getAttribute("val")), l = 11, o = 0;
            r == e - 1 && (l = this.maxM - 1), 0 == r && (o = this.minM - 1);
            for (let t = 0; t < l - o + 1; t++) a += "<div class='tooth'>" + (o + t + 1) + "</div>";
            n.innerHTML = a, d > l ? d = l : d <= o && (d = o), n.setAttribute("val", d), n.style["-webkit-transform"] = "translate3d(0," + (8 - 2 * (d - o)) + "em,0)", n.setAttribute("top", 8 - 2 * (d - o) + "em");
            let h = this.gearDate.querySelector(".date_dd");
            if (h && h.getAttribute("val")) {
                a = "";
                let t = parseInt(h.getAttribute("val")), i = this.calcDays(r, d) - 1, s = 0;
                r == e - 1 && this.maxM == d + 1 && (i = this.maxD - 1, t > i && (t = i)), 0 == r && this.minM == d + 1 && (s = this.minD - 1, t <= s && (t = s));
                for (let t = 0; t < i - s + 1; t++) a += "<div class='tooth'>" + (s + t + 1) + "</div>";
                h.innerHTML = a, h.setAttribute("val", t), h.style["-webkit-transform"] = "translate3d(0," + (8 - 2 * (t - s)) + "em,0)", h.setAttribute("top", 8 - 2 * (t - s) + "em")
            }
        }

        setGear() {
            return (t, e) => {
                null === this.gearDate || isNaN(e) || (e = Math.round(e), t.setAttribute("val", e), /date/.test(t.dataset.datetype) ? this.setDateGearTooth() : this.setTimeGearTooth())
            }
        }

        rollGear(t) {
            let e = this.setGear(), i = 0, a = !1, r = this.maxY - this.minY + 1;
            const s = () => {
                t.style.webkitTransitionDuration = t.style.transitionDuration = "200ms", a = !0
            };
            cancelAnimationFrame(t["int_" + t.id]);
            const n = () => {
                if (!this.gearDate) return void cancelAnimationFrame(t["int_" + t.id]);
                let d, l, o = t["pos_" + t.id], h = t["spd_" + t.id] * Math.exp(-.03 * i);
                if (o += h, Math.abs(h) > .1) ; else {
                    o = 2 * Math.round(o / 2), s()
                }
                o > 8 && (o = 8, s());
                let m = this.gearDate.querySelector(".date_yy");
                switch (t.dataset.datetype) {
                    case"date_yy":
                        if (d = 8 - 2 * (r - 1), o < d && (o = d, s()), a) {
                            let i = Math.abs(o - 8) / 2;
                            e(t, i), cancelAnimationFrame(t["int_" + t.id])
                        }
                        break;
                    case"date_mm":
                        l = parseInt(m.getAttribute("val"));
                        let i = 11, n = 0;
                        if (l == r - 1 && (i = this.maxM - 1), 0 == l && (n = this.minM - 1), d = 8 - 2 * (i - n), o < d && (o = d, s()), a) {
                            let i = Math.abs(o - 8) / 2 + n;
                            e(t, i), cancelAnimationFrame(t["int_" + t.id])
                        }
                        break;
                    case"date_dd":
                        let h = this.gearDate.querySelector(".date_mm");
                        l = parseInt(m.getAttribute("val"));
                        let u = parseInt(h.getAttribute("val")), c = this.calcDays(l, u) - 1, v = 0;
                        if (l == r - 1 && this.maxM == u + 1 && (c = this.maxD - 1), 0 == l && this.minM == u + 1 && (v = this.minD - 1), d = 8 - 2 * (c - v), o < d && (o = d, s()), a) {
                            let i = Math.abs(o - 8) / 2 + v;
                            e(t, i), cancelAnimationFrame(t["int_" + t.id])
                        }
                        break;
                    case"time_hh":
                        if (o < -38 && (o = -38, s()), a) {
                            let i = Math.abs(o - 8) / 2;
                            e(t, i), cancelAnimationFrame(t["int_" + t.id])
                        }
                        break;
                    case"time_mm":
                        if (o < -110 && (o = -110, s()), a) {
                            let i = Math.abs(o - 8) / 2;
                            e(t, i), cancelAnimationFrame(t["int_" + t.id])
                        }
                }
                t["pos_" + t.id] = o, t.style["-webkit-transform"] = "translate3d(0," + o + "em,0)", t.setAttribute("top", o + "em"), i++, a || requestAnimationFrame(n)
            };
            t["int_" + t.id] = requestAnimationFrame(n)
        }

        handleTouchStart() {
            return t => {
                t.preventDefault();
                let e = t.target;
                for (; !e.classList.contains("gear");) e = e.parentElement;
                cancelAnimationFrame(e["int_" + e.id]), e["old_" + e.id] = t.targetTouches[0].screenY, e["o_t_" + e.id] = (new Date).getTime();
                let i = e.getAttribute("top");
                e["o_d_" + e.id] = i ? parseFloat(i.replace(/em/g, "")) : 0, e.style.webkitTransitionDuration = e.style.transitionDuration = "0ms"
            }
        }

        handleTouchMove(t) {
            return e => {
                e.preventDefault();
                let i = e.target;
                for (; !i.classList.contains("gear");) i = i.parentElement;
                i["new_" + i.id] = e.targetTouches[0].screenY, i["n_t_" + i.id] = (new Date).getTime();
                let a = 30 * (i["new_" + i.id] - i["old_" + i.id]) / window.innerHeight;
                i["pos_" + i.id] = i["o_d_" + i.id] + a, i.style["-webkit-transform"] = "translate3d(0," + i["pos_" + i.id] + "em,0)", i.setAttribute("top", i["pos_" + i.id] + "em"), e.targetTouches[0].screenY < 1 && t(e)
            }
        }

        handleTouchEnd() {
            return t => {
                t.preventDefault();
                let e = t.target;
                for (; !e.classList.contains("gear");) e = e.parentElement;
                let i = (e["new_" + e.id] - e["old_" + e.id]) / (e["n_t_" + e.id] - e["o_t_" + e.id]);
                Math.abs(i) <= .2 ? e["spd_" + e.id] = i < 0 ? -.08 : .08 : Math.abs(i) <= .5 ? e["spd_" + e.id] = i < 0 ? -.16 : .16 : e["spd_" + e.id] = i / 2, e["pos_" + e.id] || (e["pos_" + e.id] = 0), this.rollGear(e)
            }
        }

        destroy() {
            return t => {
                let e;
                t.preventDefault();
                try {
                    e = new CustomEvent("input")
                } catch (t) {
                    e = document.createEvent("Event"), e.initEvent("input", !0, !0)
                }
                this.trigger.dispatchEvent(e), document.body.removeChild(this.gearDate), this.gearDate = null
            }
        }

        confirm(t) {
            return e => {
                let i, a, r, s, n, d, l = this.gearDate.querySelector(".date_yy"),
                    o = this.gearDate.querySelector(".date_mm");
                l && (i = this.maxY - this.minY + 1, a = parseInt(Math.round(l.getAttribute("val"))), r = parseInt(Math.round(o.getAttribute("val"))) + 1, r = r > 9 ? r : "0" + r);
                let h = this.gearDate.querySelector(".date_dd");
                h && (s = parseInt(Math.round(h.getAttribute("val"))) + 1, s = s > 9 ? s : "0" + s);
                let m = this.gearDate.querySelector(".time_hh"), u = this.gearDate.querySelector(".time_mm");
                m && (n = parseInt(Math.round(m.getAttribute("val"))), n = n > 9 ? n : "0" + n, d = parseInt(Math.round(u.getAttribute("val"))), d = d > 9 ? d : "0" + d), this.trigger.value = `${a >= 0 ? a % i + this.minY : ""}${r ? "-" + r : ""}${s ? "-" + s : ""}${s && n ? " " : ""}${n ? "" + ((n.length < 2 ? "0" : "") + n + (d.length < 2 ? ":0" : ":") + d) : ""}`, t(e)
            }
        }

        popup(t, e) {
            return () => {
                this.gearDate = document.createElement("div"), this.gearDate.className = t, this.gearDate.innerHTML = e, document.body.appendChild(this.gearDate), this.bind()
            }
        }

        bind() {
            this.defaultValueInit();
            let t = this.destroy(), e = this.confirm(t), i = this.handleTouchStart(), a = this.handleTouchEnd(),
                r = this.handleTouchMove(a);
            this.gearDate.querySelector(".lcalendar_cancel").addEventListener("touchstart", t), this.gearDate.querySelector(".lcalendar_finish").addEventListener("touchstart", e);
            let s = this.gearDate.querySelector(".date_yy"), n = this.gearDate.querySelector(".date_mm"),
                d = this.gearDate.querySelector(".date_dd"), l = this.gearDate.querySelector(".time_hh"),
                o = this.gearDate.querySelector(".time_mm");
            s && (s.addEventListener("touchstart", i), n.addEventListener("touchstart", i), s.addEventListener("touchmove", r), n.addEventListener("touchmove", r), s.addEventListener("touchend", a), n.addEventListener("touchend", a), d && (d.addEventListener("touchstart", i), d.addEventListener("touchmove", r), d.addEventListener("touchend", a))), l && (l.addEventListener("touchstart", i), o.addEventListener("touchstart", i), l.addEventListener("touchmove", r), o.addEventListener("touchmove", r), l.addEventListener("touchend", a), o.addEventListener("touchend", a))
        }

        bindEvent(t) {
            function e(t, e) {
                return `<div class="date_ctrl slideInUp">\n            <div class="date_btn_box">\n            <div class="date_btn lcalendar_cancel">取消</div>\n            <div class="date_btn lcalendar_finish">确定</div>\n            </div>\n            <div class="date_roll_mask">\n            <div class="${e || "date_roll"}">\n            ${t}\n            </div>\n            </div>\n            </div>`
            }

            let i = '<div>\n        <div class="gear date_yy" data-datetype="date_yy"></div>\n        <div class="date_grid">\n        <div>年</div>\n        </div>\n        </div>',
                a = '<div>\n        <div class="gear date_mm" data-datetype="date_mm"></div>\n        <div class="date_grid">\n        <div>月</div>\n        </div>\n        </div>',
                r = '<div>\n        <div class="gear date_dd" data-datetype="date_dd"></div>\n        <div class="date_grid">\n        <div>日</div>\n        </div>\n        </div>',
                s = '<div>\n        <div class="gear time_hh" data-datetype="time_hh"></div>\n        <div class="date_grid">\n        <div>时</div>\n        </div>\n        </div>',
                n = '<div>\n        <div class="gear time_mm" data-datetype="time_mm"></div>\n        <div class="date_grid">\n        <div>分</div>\n        </div>\n        </div>';
            this.trigger.addEventListener("click", {
                ym: this.popup("gearDate", e(`${i}${a}`, "ym_roll")),
                date: this.popup("gearDate", e(`${i}${a}${r}`)),
                datetime: this.popup("gearDatetime", e(`${i}${a}${r}${s}${n}`, "datetime_roll")),
                time: this.popup("gearDate", e(`${s}${n}`, "time_roll"))
            }[t])
        }
    }

    window.LCalendar = a, e.default = a
}]);