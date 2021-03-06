package RedisDataBase;

import java.lang.ref.WeakReference;

// 存储String以及过期时间
public class ExpireObject implements Comparable<ExpireObject>{
    long expireTime;
    WeakReference<RedisString> key;
    ExpireObject(RedisString key, long expireTime){
        this.key = new WeakReference<>(key);
        this.expireTime = expireTime;
    }

    RedisString getKey(){
        return key.get();
    }

    long getExpireTime(){
        return  expireTime;
    }


    public int compareTo(ExpireObject other){
        if(expireTime < other.getExpireTime()){
            return -1;
        }else{
            return expireTime == other.getExpireTime() ? 0 : 1;
        }
    }
}