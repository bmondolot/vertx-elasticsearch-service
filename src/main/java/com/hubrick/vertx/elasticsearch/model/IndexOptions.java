/**
 * Copyright (C) 2016 Etaia AS (oss@hubrick.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hubrick.vertx.elasticsearch.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import org.elasticsearch.action.index.IndexRequest;

/**
 * Index operation options
 */
@DataObject
public class IndexOptions extends AbstractWriteOptions<IndexOptions> {

    private String id;
    private IndexRequest.OpType opType;
    private String timestamp;
    private Long ttl;

    public static final String FIELD_ID = "id";
    public static final String FIELD_OP_TYPE = "opType";
    public static final String FIELD_TIMESTAMP = "timestamp";
    public static final String FIELD_TTL = "ttl";

    public IndexOptions() {
    }

    public IndexOptions(IndexOptions other) {
        super(other);

        id = other.getId();
        opType = other.getOpType();
        timestamp = other.getTimestamp();
        ttl = other.getTtl();

    }

    public IndexOptions(JsonObject json) {
        super(json);

        id = json.getString(FIELD_ID);
        timestamp = json.getString(FIELD_TIMESTAMP);
        ttl = json.getLong(FIELD_TTL);

        String s = json.getString(FIELD_OP_TYPE);
        if (s != null) opType = IndexRequest.OpType.fromString(s);
    }

    public String getId() {
        return id;
    }

    public IndexOptions setId(String id) {
        this.id = id;
        return this;
    }

    public IndexRequest.OpType getOpType() {
        return opType;
    }

    public IndexOptions setOpType(IndexRequest.OpType opType) {
        this.opType = opType;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public IndexOptions setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Long getTtl() {
        return ttl;
    }

    public IndexOptions setTtl(Long ttl) {
        this.ttl = ttl;
        return this;
    }

    @Override
    public JsonObject toJson() {
        JsonObject json = super.toJson();

        if (getId() != null) json.put(FIELD_ID, getId());
        if (getOpType() != null) json.put(FIELD_OP_TYPE, getOpType().toString().toLowerCase());
        if (getTimestamp() != null) json.put(FIELD_TIMESTAMP, getTimestamp());
        if (getTtl() != null) json.put(FIELD_TTL, getTtl());

        return json;
    }

}
