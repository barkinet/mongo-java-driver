/*
 * Copyright (c) 2008 - 2012 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb;

import org.mongodb.MongoCollection;
import org.mongodb.MongoCursor;
import org.mongodb.operation.MongoFind;

public class DBCursor {
    private final MongoCollection<DBObject> collection;
    private final MongoFind find;
    private MongoCursor<DBObject> cursor;

    public DBCursor(final MongoCollection<DBObject> collection, final MongoFind find) {
        this.collection = collection;
        this.find = find;
    }

    public DBCursor limit(final int limit) {
        find.limit(limit);
        return this;
    }

    public DBCursor batchSize(final int batchSize) {
        find.batchSize(batchSize);
        return this;
    }

    public DBCursor skip(final int skip) {
        find.offset(skip);
        return this;
    }

    public boolean hasNext() {
        if (cursor == null) {
            cursor = collection.find(find);
        }
        return cursor.hasNext();
    }

    public DBObject next() {
        if (cursor == null) {
            cursor = collection.find(find);
        }
        return cursor.next();
    }


}