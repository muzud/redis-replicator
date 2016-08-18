/*
 * Copyright 2016 leon chen
 *
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

package com.moilioncircle.redis.replicator.cmd.impl;

import com.moilioncircle.redis.replicator.cmd.Command;
import com.moilioncircle.redis.replicator.cmd.CommandName;
import com.moilioncircle.redis.replicator.cmd.CommandParser;

/**
 * Created by leon on 8/14/16.
 */
public class HIncrByParser implements CommandParser<HIncrByParser.HIncrByCommand> {

    @Override
    public HIncrByCommand parse(CommandName cmdName, Object[] params) {
        int idx = 0;
        String key = (String) params[idx++];
        String field = (String) params[idx++];
        int increment = Integer.parseInt((String) params[idx++]);
        return new HIncrByCommand(key, field, increment);
    }

    public static class HIncrByCommand implements Command {
        public final String key;
        public final String field;
        public final int increment;

        public HIncrByCommand(String key, String field, int increment) {
            this.key = key;
            this.field = field;
            this.increment = increment;
        }

        @Override
        public String toString() {
            return "HIncrByCommand{" +
                    "key='" + key + '\'' +
                    ", field='" + field + '\'' +
                    ", increment='" + increment + '\'' +
                    '}';
        }

        @Override
        public CommandName name() {
            return CommandName.name("HINCRBY");
        }
    }
}
