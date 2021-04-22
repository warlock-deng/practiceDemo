package completable;//package completable;
//
//
//import com.sun.deploy.net.HttpUtils;
//
//import java.text.MessageFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.TimeUnit;
//
///**
// * 说明
// *
// * @author warlock.deng
// * Created at 2019/5/6 15:46
// */
//public class Future {
//
//   // private static RedissonClient redissonClient = null;
//
//    private final static String jobInterfaceUrl = "http://api.open.zhaopin.com/platform/job/getjobbyjobnumber?access_token=e8cfb5178bff42a6a9b201beeb33dc65pcuE&jobnum={0}&isjobonsite=1";
//
//    public Future() {
//        getRedissonClient();
//    }
//
//    public List<Job> getJobsAsync(String[] jobNumbers) {
//        List<Job> jobs = new ArrayList<>();
//        List<CompletableFuture<Object>> completableFutures = new ArrayList<>();
//        for (String jobNumber : jobNumbers) {
//            CompletableFuture<Object> completableFuture = getJobFromCache(jobNumber).handle((cacheValue, throwable) -> {
//                if (throwable != null) {
//                    throwable.printStackTrace();
//                    return getJobFromInterface(jobNumber);
//                }
//                if (null == cacheValue) {
//                    return getJobFromInterface(jobNumber);
//                }
//                return cacheValue;
//            }).thenApply((cacheValue) -> {
//                setCache(jobNumber, cacheValue);
//                return true;
//            });
//            completableFutures.add(completableFuture);
//        }
//        for (int i = 0; i < completableFutures.size(); i++) {
//            try {
//                Job job = (Job) completableFutures.get(i).get();
//                jobs.add(job);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return jobs;
//    }
//
//    public List<Job> getJobsSyne(String[] jobNumbers) {
//        List<Job> jobs = new ArrayList<>();
//        for (String jobNumber : jobNumbers) {
//            Job job = getJobFromCacheBySync(jobNumber);
//            if (null == job) {
//                job = getJobFromInterface(jobNumber);
//                setCache(jobNumber, job);
//                jobs.add(job);
//            }
//        }
//        return jobs;
//    }
//
//
////    private CompletableFuture<Job> getJobFromCache(String jobNumber) {
////        RBucket<Job> bucket = redissonClient.getBucket(jobNumber);
////        return bucket.getAsync().toCompletableFuture();
////    }
////
////    private Job getJobFromCacheBySync(String jobNumber) {
////        RBucket<Job> bucket = redissonClient.getBucket(jobNumber);
////        return bucket.get();
////    }
////
////    private Job getJobFromInterface(String jobNumber) {
////        String url = MessageFormat.format(jobInterfaceUrl, jobNumber);
////        JsonResponseHolder jsonResponseHolder = HttpUtils.createGet(url).queryAsJson();
////        if (jsonResponseHolder.getStatus() != 200) {
////            return null;
////        }
////
////        return jsonResponseHolder.getValue(Job.class);
////    }
//
////    private void getRedissonClient() {
////        if (null != redissonClient) {
////            return;
////        }
////        Config config = new Config();
////        ClusterServersConfig clusterServersConfig = config.useClusterServers();
////        clusterServersConfig.addNodeAddress(new String[]{"redis://172.17.6.10:6379", "redis://172.17.6.11:6379"});
////        redissonClient = Redisson.create(config);
////    }
////
////    private void setCache(String jobNumber, Object job) {
////        if (null == job) {
////            return;
////        }
////        RBucket rBitSet = redissonClient.getBucket(jobNumber);
////        rBitSet.setAsync(job, 10, TimeUnit.MINUTES).toCompletableFuture().thenApply((result) -> null);
////    }
//
//}
