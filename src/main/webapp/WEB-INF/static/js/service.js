//厂别
(function($, doc) {
    $.init();
    $.ready(function() {
        /**
         * 获取对象属性的值
         * 主要用于过滤三级联动中，可能出现的最低级的数据不存在的情况，实际开发中需要注意这一点；
         * @param {Object} obj 对象
         * @param {String} param 属性名
         */
        var _getParam = function(obj, param) {
            return obj[param] || '';
        };
        var userPicker = new $.PopPicker();
        userPicker.setData([{
            text: 'PHC'
        }, {
            text: 'PHCJ'
        },{
            text:'PHP'
        },{
            text:'PHCJ1'
        }]);
        var showUserPickerButton = doc.getElementById('showUserPicker');
        var userResult = doc.getElementById('userResult');
        showUserPickerButton.addEventListener('tap', function(event) {
            userPicker.show(function(items) {
                userResult.innerText = JSON.stringify(items[0].text);
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);
    });
})(mui, document);

//地点
(function($, doc) {
    $.init();
    $.ready(function() {
        var _getParam = function(obj, param) {
            return obj[param] || '';
        };
        var userPicker = new $.PopPicker();
        userPicker.setData([{
            text: '行政课'
        }, {
            text: '人事课'
        },{
            text:'财务课'
        },{
            text:'资讯课'
        },{
            text:'EHS课'
        },{
            text:'部品保证课'
        },{
            text:'品管一课'
        },{
            text:'品管二课'
        },{
            text:'实验课'
        },{
            text:'CQS课'
        },{
            text:'统购课'
        },{
            text:'生管课'
        },{
            text:'物控课'
        },{
            text:'资材课'
        },{
            text:'关务部'
        },{
            text:'专案部'
        },{
            text:'工程部'
        },{
            text:'制一部'
        },{
            text:'制二部'
        },{
            text:'SMT部'
        },{
            text:'产品工程部'
        },{
            text:'供应商品质管理部'
        }]);
        var showUserPickerButton = doc.getElementById('showUserPicker2');
        var userResult = doc.getElementById('userResult2');
        showUserPickerButton.addEventListener('tap', function(event) {
            userPicker.show(function(items) {
                userResult.innerText = JSON.stringify(items[0].text);
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);
    });
})(mui, document);

//维修内容
(function($, doc) {
    $.init();
    $.ready(function() {
        var _getParam = function(obj, param) {
            return obj[param] || '';
        };
        var userPicker = new $.PopPicker();
        userPicker.setData([{
            text: 'Citrix'
        }, {
            text: '印表机'
        },{
            text:'MES问题'
        },{
            text:'网络问题'
        },{
            text:'硬件问题'
        },{
            text:'视讯问题'
        },{
            text:'其他问题'
        }]);
        var showUserPickerButton = doc.getElementById('showUserPicker3');
        var userResult = doc.getElementById('userResult3');
        showUserPickerButton.addEventListener('tap', function(event) {
            userPicker.show(function(items) {
                userResult.innerText = JSON.stringify(items[0].text);
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);
    });
})(mui, document);


//负责人
(function($, doc) {
    $.init();
    $.ready(function() {
        var _getParam = function(obj, param) {
            return obj[param] || '';
        };
        var userPicker = new $.PopPicker();
        userPicker.setData([{
            text:'余小勇'
        },{
            text: '杨世荣'
        }, {
            text: '廖永'
        },{
            text:'韩琪'
        },{
            text:'陈志良'
        },{
            text:'陈雄威'
        },{
            text:'肖宇正'
        },{
            text:'陈海淼'
        },{
            text:'龍斌'
        },{
            text:'周正'
        },{
            text:'聶利进'
        },{
            text:'高鹏飞'
        },{
            text:'罗烜'
        }]);
        var showUserPickerButton = doc.getElementById('showUserPicker4');
        var userResult = doc.getElementById('userResult4');
        showUserPickerButton.addEventListener('tap', function(event) {
            userPicker.show(function(items) {
                userResult.innerText = JSON.stringify(items[0].text);
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);
    });
})(mui, document);