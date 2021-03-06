/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.co.yahoo.presto.audit;

import com.facebook.presto.spi.eventlistener.EventListener;
import com.facebook.presto.spi.eventlistener.EventListenerFactory;
import io.airlift.log.Logger;

import java.util.Map;

import static java.util.Objects.requireNonNull;

public class AuditLogFactory
        implements EventListenerFactory
{
    private static final Logger log = Logger.get(AuditLogFactory.class);

    @Override
    public String getName()
    {
        return "presto-audit-log";
    }

    @Override
    public EventListener create(Map<String, String> requiredConfig)
    {
        requireNonNull(requiredConfig, "requiredConfig is null");
        return new AuditLogListener(requiredConfig);
    }
}
