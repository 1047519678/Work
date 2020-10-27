package cn.mvc.tools;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataTableJson {
    /**
     * Layui Table Json 格式
     * @param list 查询数据
     * @param page 当前页数
     * @param limit 行数
     * @param <T> 泛型
     * @return JSON
     */
    public static<T> JSONObject getTableJson(List<T> list, String page, String limit){
        String msg = "";
        List<T> dataList = list;
        List<T> dataListByLimit = new ArrayList<>();
        int dataListSize = dataList.size();
        int minSize = (Integer.parseInt(page) - 1) * Integer.parseInt(limit) + 1;
        int maxSize = Integer.parseInt(page) * Integer.parseInt(limit);
        int size = 0;
        if (dataList.iterator().hasNext()) {
            for (T obj : dataList) {
                size++;
                if (size >= minSize && size <= maxSize) {
                    dataListByLimit.add(obj);
                }
            }
            msg = "查询成功";
        }
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", msg);
        json.put("count", dataListSize);
        json.put("data", dataListByLimit);
        return json;
    }
}
