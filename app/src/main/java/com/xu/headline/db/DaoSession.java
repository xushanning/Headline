package com.xu.headline.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.xu.headline.db.dbbean.NewsHistoryDbBean;
import com.xu.headline.db.dbbean.SubscribeChannelDbBean;
import com.xu.headline.db.dbbean.VideoChannelDbBean;

import com.xu.headline.db.NewsHistoryDbBeanDao;
import com.xu.headline.db.SubscribeChannelDbBeanDao;
import com.xu.headline.db.VideoChannelDbBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig newsHistoryDbBeanDaoConfig;
    private final DaoConfig subscribeChannelDbBeanDaoConfig;
    private final DaoConfig videoChannelDbBeanDaoConfig;

    private final NewsHistoryDbBeanDao newsHistoryDbBeanDao;
    private final SubscribeChannelDbBeanDao subscribeChannelDbBeanDao;
    private final VideoChannelDbBeanDao videoChannelDbBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        newsHistoryDbBeanDaoConfig = daoConfigMap.get(NewsHistoryDbBeanDao.class).clone();
        newsHistoryDbBeanDaoConfig.initIdentityScope(type);

        subscribeChannelDbBeanDaoConfig = daoConfigMap.get(SubscribeChannelDbBeanDao.class).clone();
        subscribeChannelDbBeanDaoConfig.initIdentityScope(type);

        videoChannelDbBeanDaoConfig = daoConfigMap.get(VideoChannelDbBeanDao.class).clone();
        videoChannelDbBeanDaoConfig.initIdentityScope(type);

        newsHistoryDbBeanDao = new NewsHistoryDbBeanDao(newsHistoryDbBeanDaoConfig, this);
        subscribeChannelDbBeanDao = new SubscribeChannelDbBeanDao(subscribeChannelDbBeanDaoConfig, this);
        videoChannelDbBeanDao = new VideoChannelDbBeanDao(videoChannelDbBeanDaoConfig, this);

        registerDao(NewsHistoryDbBean.class, newsHistoryDbBeanDao);
        registerDao(SubscribeChannelDbBean.class, subscribeChannelDbBeanDao);
        registerDao(VideoChannelDbBean.class, videoChannelDbBeanDao);
    }
    
    public void clear() {
        newsHistoryDbBeanDaoConfig.clearIdentityScope();
        subscribeChannelDbBeanDaoConfig.clearIdentityScope();
        videoChannelDbBeanDaoConfig.clearIdentityScope();
    }

    public NewsHistoryDbBeanDao getNewsHistoryDbBeanDao() {
        return newsHistoryDbBeanDao;
    }

    public SubscribeChannelDbBeanDao getSubscribeChannelDbBeanDao() {
        return subscribeChannelDbBeanDao;
    }

    public VideoChannelDbBeanDao getVideoChannelDbBeanDao() {
        return videoChannelDbBeanDao;
    }

}
