package xin.zachary.nffn.serviceimpl;

import org.springframework.stereotype.Service;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.DistanceFunction;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import xin.zachary.nffn.entity.UserMapping;
import xin.zachary.nffn.service.UserMappingService;

import java.io.File;
import java.io.IOException;

@Service("userMappingService")
public class UserMappingServiceImpl extends BaseServiceImpl<UserMapping> implements UserMappingService {
    private Instances instances;
    private SimpleKMeans kMeans;
    private DistanceFunction difFun;
    private ArffLoader loader;
    private ClusterEvaluation clusterEvaluation;//聚类评估期

    //主要按照用户的喜好度对用户进行分类，传入的参数为一个weka能够识别的txt文件
    @Override
    public double[] mapping(File file) {
        initWeka();
        try {
            //读取样本数据
            loader.setFile(file);
            instances = loader.getDataSet();

            //加载算法
            kMeans.setNumClusters(8);//这里的数字表示要把样本聚成多少类
            kMeans.buildClusterer(instances);
            clusterEvaluation.setClusterer(kMeans);
            clusterEvaluation.evaluateClusterer(new Instances(instances));

            //记录聚类后每个样本所属的类别
            double[] result = clusterEvaluation.getClusterAssignments();
            //排除0的干扰,是的排列为从1到定义的类别个数
            for (int i = 0; i < result.length; i++) {
                result[i]+=1;
                System.out.println(result[i]+" ");
            }
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //初始化weka所有用的变量
    private void initWeka(){
        clusterEvaluation = new ClusterEvaluation();
        loader = new ArffLoader();
        instances = null;
        kMeans = new SimpleKMeans();
        difFun = null;
    }
}
