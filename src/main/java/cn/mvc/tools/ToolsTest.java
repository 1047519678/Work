package cn.mvc.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToolsTest {
    @Autowired
    private JedisClientSignle jedisClientSignle;

    public static void main(String[] args) {

    }
}
