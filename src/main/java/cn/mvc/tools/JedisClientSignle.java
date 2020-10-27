package cn.mvc.tools;
import cn.mvc.service.JedisClient;
import org.apache.commons.codec.CharEncoding;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JedisClientSignle implements JedisClient {
    @Autowired
    private JedisPool jedisPool;
    int db = 17;
    private static Logger logger = Logger.getLogger(JedisClientSignle.class);

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        String str = jedis.get(key);
        jedis.close();
        logger.info("jedis释放成功");
        return str;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        String str = jedis.set(key,value);
        jedis.close();
        logger.info("jedis释放成功");
        return str;
    }

    @Override
    public String setList(String key, List<?> value) {
        return null;
    }

    @Override
    public List<?> getList(String key) {
        return null;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        Long result = jedis.hset(hkey,key,value);
        jedis.close();
        logger.info("jedis释放成功");
        return result;
    }

    @Override
    public String hashGet(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        String str = jedis.hget(key,value);
        jedis.close();
        logger.info("jedis释放成功");
        return str;
    }

    @Override
    public long hashDel(String hkey, String key) {
        return 0;
    }

    @Override
    public long listPush(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        Long result = jedis.lpush(key,value);
        jedis.close();
        logger.info("jedis释放成功");
        return result;
    }

    @Override
    public long listSize(String key) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        long result = jedis.llen(key);
        jedis.close();
        logger.info("jedis释放成功");
        return result;
    }

    @Override
    public List<?> listRange(String key, int start, int stop) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        List list = jedis.lrange(key,(long)start,(long)stop);
        jedis.close();
        logger.info("jedis释放成功");
        return list;
    }

    @Override
    public long tt1(String key) {
        return 0;
    }

    @Override
    public long expire(String key, int second) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        Long result = jedis.expire(key,second);
        jedis.close();
        logger.info("jedis释放成功");
        return result;
    }

    @Override
    public long incr(String key) {
        return 0;
    }

    @Override
    public long del(String key) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        Long result = jedis.del(key);
        jedis.close();
        logger.info("jedis释放成功");
        return result;
    }

    /*@Override
    public String setList(String key, List<?> list) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        String result = "";
        try{
            if(list != null && !list.isEmpty()){
                result = jedis.set(key.getBytes(),SerializeUtil.serializeList(list));
            }else{
                jedis.set(key.getBytes(), "".getBytes());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        jedis.close();
        logger.info("jedis释放成功");
        return result;
    }

    @Override
    public List<?> getList(String key) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);

        if(jedis==null || !jedis.exists(key)){
            return null;
        }
        byte[] data = jedis.get(key.getBytes());
        jedis.close();
        logger.info("jedis释放成功");
        return SerializeUtil.unSerializeList(data);
    }*/

    @Override
    public long listPushObject(String key, Object value) throws UnsupportedEncodingException {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        String _value = new String(SerializeUtil.serialize(value), CharEncoding.ISO_8859_1);
        Long result = jedis.lpush(key, _value);
        jedis.close();
        logger.info("jedis释放成功");
        return result;
    }

    @Override
    public List<Map<String,Object>> listRangeObject(String key, int start, int stop){
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        List list = jedis.lrange(key,(long)start,(long)stop);
        jedis.close();
        logger.info("jedis释放成功");
        List<Map<String,Object>> reList = new ArrayList<>();
        try{
            if(null != list && list.size()>0){
                for(Object obj:list){
                    byte[] data = obj.toString().getBytes(CharEncoding.ISO_8859_1);
                    Map<String,Object> map = (Map<String,Object>) SerializeUtil.unSerialize(data);
                    reList.add(map);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return reList;
    }

    @Override
    public void setObject(String key, Object o) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        try{
            o = o == null ? new Object():o;
            jedis.set(key.getBytes(),SerializeUtil.serialize(o));
        }catch (Exception e){
            e.printStackTrace();
        }
        jedis.close();
        logger.info("jedis释放成功");
    }

    @Override
    public Object getObject(String key) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        if(jedis == null || !jedis.exists(key)){
            return null;
        }
        byte[] data = jedis.get(key.getBytes());
        jedis.close();
        logger.info("jedis释放成功");
        return (Object)SerializeUtil.unSerialize(data);
    }

    @Override
    public void clear() {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        jedis.flushDB();
        jedis.close();
        logger.info("jedis释放成功");
    }

    @Override
    public Object removeObject(String key) {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        Object obj = jedis.expire(SerializeUtil.serialize(key),0);
        jedis.close();
        logger.info("jedis释放成功");
        return obj;
    }

    @Override
    public int getSize() {
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        String sizeStr = jedis.dbSize().toString();
        jedis.close();
        logger.info("jedis释放成功");
        return Integer.valueOf(sizeStr);
    }

    //保存文件方法
    public void setFile(String key,String path){
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        File fr = new File(path);
        try{
            jedis.set(key.getBytes(), SerializeUtil.serialize(fr));
        }catch (Exception e){
            e.printStackTrace();
        }
        jedis.close();
        logger.info("jedis释放成功");
    }

    //读取文件对象方法
    public File getFile(String key){
        Jedis jedis = jedisPool.getResource();
        logger.info("jedis连接成功！DB："+db);
        jedis.select(db);
        File file = (File)SerializeUtil.unSerialize(jedis.get(key.getBytes()));
        jedis.close();
        logger.info("jedis释放成功");
        return file;
    }

    public static void main(String[] args){
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数（100个足够用了，没必要设置太大）
        config.setMaxTotal(600);
        //最大空闲连接数
        config.setMaxIdle(300);
        //获取Jedis连接的最大等待时间（50秒）
        config.setMaxWaitMillis(50 * 1000);
        //在获取Jedis连接时，自动检验连接是否可用
        config.setTestOnBorrow(true);
        //在将连接放回池中前，自动检验连接是否有效
        config.setTestOnReturn(true);
        //自动测试池中的空闲连接是否都是可用连接
        config.setTestWhileIdle(true);
        JedisPool jedisPool = new JedisPool(config,"192.168.61.146",6379,100000,"chenjunjia");
        for(int i=0;i<2000;i++){
            Jedis jedis = jedisPool.getResource();
            jedis.select(1);
            jedis.get("test");
            jedis.close();
            //jedis = null;
            String aa=jedis.get("test");
            System.out.println("jedis第"+i+"次："+aa);
        }
    }
}
