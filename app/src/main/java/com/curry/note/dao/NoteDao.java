package com.curry.note.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.curry.note.bean.bmob.Note;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "NOTE".
*/
public class NoteDao extends AbstractDao<Note, Long> {

    public static final String TABLENAME = "NOTE";

    /**
     * Properties of entity Note.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property NoteContent = new Property(0, String.class, "noteContent", false, "NOTE_CONTENT");
        public final static Property Timestamp = new Property(1, Long.class, "timestamp", true, "_id");
        public final static Property UserId = new Property(2, String.class, "userId", false, "USER_ID");
    }


    public NoteDao(DaoConfig config) {
        super(config);
    }
    
    public NoteDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"NOTE\" (" + //
                "\"NOTE_CONTENT\" TEXT," + // 0: noteContent
                "\"_id\" INTEGER PRIMARY KEY ," + // 1: timestamp
                "\"USER_ID\" TEXT);"); // 2: userId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NOTE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Note entity) {
        stmt.clearBindings();
 
        String noteContent = entity.getNoteContent();
        if (noteContent != null) {
            stmt.bindString(1, noteContent);
        }
 
        Long timestamp = entity.getTimestamp();
        if (timestamp != null) {
            stmt.bindLong(2, timestamp);
        }
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(3, userId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Note entity) {
        stmt.clearBindings();
 
        String noteContent = entity.getNoteContent();
        if (noteContent != null) {
            stmt.bindString(1, noteContent);
        }
 
        Long timestamp = entity.getTimestamp();
        if (timestamp != null) {
            stmt.bindLong(2, timestamp);
        }
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(3, userId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1);
    }    

    @Override
    public Note readEntity(Cursor cursor, int offset) {
        Note entity = new Note( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // noteContent
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // timestamp
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // userId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Note entity, int offset) {
        entity.setNoteContent(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTimestamp(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setUserId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Note entity, long rowId) {
        entity.setTimestamp(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Note entity) {
        if(entity != null) {
            return entity.getTimestamp();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Note entity) {
        return entity.getTimestamp() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
