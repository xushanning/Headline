package com.xu.headline.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.xu.headline.db.helper.ChannelListConvert;
import java.util.List;

import com.xu.headline.db.dbbean.SubscribeChannelDbBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SUBSCRIBE_CHANNEL_DB_BEAN".
*/
public class SubscribeChannelDbBeanDao extends AbstractDao<SubscribeChannelDbBean, Long> {

    public static final String TABLENAME = "SUBSCRIBE_CHANNEL_DB_BEAN";

    /**
     * Properties of entity SubscribeChannelDbBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property IMei = new Property(1, String.class, "iMei", false, "I_MEI");
        public final static Property Channels = new Property(2, String.class, "channels", false, "CHANNELS");
        public final static Property Time = new Property(3, long.class, "time", false, "TIME");
    }

    private final ChannelListConvert channelsConverter = new ChannelListConvert();

    public SubscribeChannelDbBeanDao(DaoConfig config) {
        super(config);
    }
    
    public SubscribeChannelDbBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SUBSCRIBE_CHANNEL_DB_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"I_MEI\" TEXT," + // 1: iMei
                "\"CHANNELS\" TEXT," + // 2: channels
                "\"TIME\" INTEGER NOT NULL );"); // 3: time
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SUBSCRIBE_CHANNEL_DB_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SubscribeChannelDbBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String iMei = entity.getIMei();
        if (iMei != null) {
            stmt.bindString(2, iMei);
        }
 
        List channels = entity.getChannels();
        if (channels != null) {
            stmt.bindString(3, channelsConverter.convertToDatabaseValue(channels));
        }
        stmt.bindLong(4, entity.getTime());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SubscribeChannelDbBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String iMei = entity.getIMei();
        if (iMei != null) {
            stmt.bindString(2, iMei);
        }
 
        List channels = entity.getChannels();
        if (channels != null) {
            stmt.bindString(3, channelsConverter.convertToDatabaseValue(channels));
        }
        stmt.bindLong(4, entity.getTime());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public SubscribeChannelDbBean readEntity(Cursor cursor, int offset) {
        SubscribeChannelDbBean entity = new SubscribeChannelDbBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // iMei
            cursor.isNull(offset + 2) ? null : channelsConverter.convertToEntityProperty(cursor.getString(offset + 2)), // channels
            cursor.getLong(offset + 3) // time
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SubscribeChannelDbBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIMei(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setChannels(cursor.isNull(offset + 2) ? null : channelsConverter.convertToEntityProperty(cursor.getString(offset + 2)));
        entity.setTime(cursor.getLong(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(SubscribeChannelDbBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(SubscribeChannelDbBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(SubscribeChannelDbBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
