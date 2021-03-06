/*
 * Copyright 2016 Sam Sun <me@samczsun.com>
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.javadeobfuscator.deobfuscator.transformers;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.javadeobfuscator.deobfuscator.Deobfuscator;
import com.javadeobfuscator.deobfuscator.config.TransformerConfig;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public abstract class Transformer<T extends TransformerConfig> {

    protected Map<String, ClassNode> classes;
    protected Map<String, ClassNode> classpath;

    private Deobfuscator deobfuscator;
    private T config;

    public void init(Deobfuscator deobfuscator, TransformerConfig config, Map<String, ClassNode> classes, Map<String, ClassNode> classpath) {
        this.deobfuscator = deobfuscator;
        this.classes = classes;
        this.classpath = classpath;
        this.config = (T) config;
    }

    public T getConfig() {
        return this.config;
    }

    public Collection<ClassNode> classNodes() {
        return this.classes.values();
    }

    public abstract boolean transform() throws Throwable;

    public Deobfuscator getDeobfuscator() {
        return this.deobfuscator;
    }
}
