package cdu.gu.common.context;

import java.util.LinkedHashMap;

public class BCtx {
    private static final ThreadLocal<LinkedHashMap<String, Object>> THREAD_LOCAL =
            new ThreadLocal<>();
    public static final String KEY_ADMIN_USER_ID = "admin_id";
    public static final String KEY_ADMIN_USER = "admin_user";
    public static final String KEY_ADMIN_PER = "admin_per";
    public static final String KEY_CONFIG = "config";

    public BCtx(){}

    private static void put(String key,Object val){
        LinkedHashMap<String,Object> hashMap = THREAD_LOCAL.get();
        if (hashMap == null){
            hashMap = new LinkedHashMap<>();
        }
        hashMap.put(key,val);
        THREAD_LOCAL.set(hashMap);
    }
    private static Object get(String key){
        if (THREAD_LOCAL.get() == null){
            return null;
        }
        return THREAD_LOCAL.get().getOrDefault(key,null);
    }
    public static boolean isNull(){return THREAD_LOCAL.get() == null;}
    public static void remove(){THREAD_LOCAL.remove();}
    public static Integer getId(){return (Integer) get(KEY_ADMIN_USER_ID);}
    public static void setId(Integer userId){put(KEY_ADMIN_USER_ID,userId);}
    public static AdminUser

}
