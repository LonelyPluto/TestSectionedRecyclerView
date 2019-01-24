package com.lonelypluto.testsectionedrecyclerview;

import android.content.Context;
import android.os.Environment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;

import java.io.File;

/**
 * @Description: Glide配置缓存路径和大小
 * @author: ZhangYW
 * @time: 2018/8/22 14:12
 */

@GlideModule
public class GlideModuleConfig extends AppGlideModule {
    //存储路径
    private static final String SD_PATH = Environment.getExternalStorageDirectory() + "/lonelypluto/glide/";
    /**
     * 设置glide缓存路径
     */
    private static String CACHE_DIRECTORY = "cache";

    int diskSize = 1024 * 1024 * 100;
    int memorySize = (int) (Runtime.getRuntime().maxMemory()) / 8;  // 取1/8最大内存作为最大缓存
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        super.applyOptions(context, builder);

        File file =new File(SD_PATH);
        if(!file.exists()) {
            file.mkdir();
        }

        File file_cache =new File(CACHE_DIRECTORY);
        if(!file_cache.exists()) {
            file_cache.mkdir();
        }

        builder.setDiskCache(new DiskLruCacheFactory(SD_PATH,CACHE_DIRECTORY,diskSize));
        // 自定义内存和图片池大小
        builder.setMemoryCache(new LruResourceCache(memorySize));
        builder.setBitmapPool(new LruBitmapPool(memorySize));
    }

    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        super.registerComponents(context, glide, registry);
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
