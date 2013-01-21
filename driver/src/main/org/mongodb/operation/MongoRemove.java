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

package org.mongodb.operation;

import org.mongodb.WriteConcern;

public class MongoRemove extends MongoWrite {
    private final MongoQueryFilter filter;
    private boolean isMulti = false;

    public MongoRemove(final MongoQueryFilter filter) {
        this.filter = filter;
    }

    public MongoQueryFilter getFilter() {
        return filter;
    }

    //CHECKSTYLE:OFF
    public MongoRemove multi(final boolean isMulti) {
        this.isMulti = isMulti;
        return this;
    }
    //CHECKSTYLE:ON

    public boolean isMulti() {
        return isMulti;
    }

    @Override
    public MongoRemove writeConcern(final WriteConcern writeConcern) {
        super.writeConcern(writeConcern);
        return this;
    }

    @Override
    public MongoRemove writeConcernIfAbsent(final WriteConcern writeConcern) {
        super.writeConcernIfAbsent(writeConcern);
        return this;
    }
}
