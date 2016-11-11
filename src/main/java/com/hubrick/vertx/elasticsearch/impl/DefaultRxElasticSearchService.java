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
package com.hubrick.vertx.elasticsearch.impl;

import com.hubrick.vertx.elasticsearch.DeleteByQueryOptions;
import com.hubrick.vertx.elasticsearch.DeleteOptions;
import com.hubrick.vertx.elasticsearch.ElasticSearchService;
import com.hubrick.vertx.elasticsearch.GetOptions;
import com.hubrick.vertx.elasticsearch.IndexOptions;
import com.hubrick.vertx.elasticsearch.RxElasticSearchService;
import com.hubrick.vertx.elasticsearch.SearchOptions;
import com.hubrick.vertx.elasticsearch.SearchScrollOptions;
import com.hubrick.vertx.elasticsearch.SuggestOptions;
import com.hubrick.vertx.elasticsearch.UpdateOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.rx.java.ObservableFuture;
import io.vertx.rx.java.RxHelper;
import rx.Observable;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Emir Dizdarevic
 * @since 1.0.0
 */
public class DefaultRxElasticSearchService implements RxElasticSearchService {

    private final ElasticSearchService elasticSearchService;

    public DefaultRxElasticSearchService(ElasticSearchService elasticSearchService) {
        checkNotNull(elasticSearchService, "elasticSearchService must not be null");

        this.elasticSearchService = elasticSearchService;
    }

    @Override
    public Observable<JsonObject> index(String index, String type, JsonObject source, IndexOptions options) {
        final ObservableFuture<JsonObject> observableFuture = RxHelper.observableFuture();
        elasticSearchService.index(index, type, source, options, observableFuture.toHandler());
        return observableFuture;
    }

    @Override
    public Observable<JsonObject> update(String index, String type, String id, UpdateOptions options) {
        final ObservableFuture<JsonObject> observableFuture = RxHelper.observableFuture();
        elasticSearchService.update(index, type, id, options, observableFuture.toHandler());
        return observableFuture;
    }

    @Override
    public Observable<JsonObject> get(String index, String type, String id, GetOptions options) {
        final ObservableFuture<JsonObject> observableFuture = RxHelper.observableFuture();
        elasticSearchService.get(index, type, id, options, observableFuture.toHandler());
        return observableFuture;

    }

    @Override
    public Observable<JsonObject> search(List<String> indices, SearchOptions options) {
        final ObservableFuture<JsonObject> observableFuture = RxHelper.observableFuture();
        elasticSearchService.search(indices, options, observableFuture.toHandler());
        return observableFuture;

    }

    @Override
    public Observable<JsonObject> searchScroll(String scrollId, SearchScrollOptions options) {
        final ObservableFuture<JsonObject> observableFuture = RxHelper.observableFuture();
        elasticSearchService.searchScroll(scrollId, options, observableFuture.toHandler());
        return observableFuture;

    }

    @Override
    public Observable<JsonObject> delete(String index, String type, String id, DeleteOptions options) {
        final ObservableFuture<JsonObject> observableFuture = RxHelper.observableFuture();
        elasticSearchService.delete(index, type, id, options, observableFuture.toHandler());
        return observableFuture;

    }

    @Override
    public Observable<JsonObject> suggest(List<String> indices, SuggestOptions options) {
        final ObservableFuture<JsonObject> observableFuture = RxHelper.observableFuture();
        elasticSearchService.suggest(indices, options, observableFuture.toHandler());
        return observableFuture;

    }

    @Override
    public Observable<JsonObject> deleteByQuery(List<String> indices, JsonObject query, DeleteByQueryOptions options) {
        final ObservableFuture<JsonObject> observableFuture = RxHelper.observableFuture();
        elasticSearchService.deleteByQuery(indices, query, options, observableFuture.toHandler());
        return observableFuture;
    }
}