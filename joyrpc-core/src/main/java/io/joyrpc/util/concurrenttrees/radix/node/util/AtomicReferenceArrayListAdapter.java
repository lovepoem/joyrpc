/**
 * Copyright 2012-2013 Niall Gallagher
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.joyrpc.util.concurrenttrees.radix.node.util;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * Wraps an {@link AtomicReferenceArray} to implement read-only methods of the {@link java.util.List} interface.
 * <p/>
 * This enables binary search of an {@link AtomicReferenceArray}, using
 * {@link java.util.Collections#binarySearch(java.util.List, Object)}.
 *
 * @author Niall Gallagher
 */
public class AtomicReferenceArrayListAdapter<T> extends AbstractList<T> implements Serializable {

    private final AtomicReferenceArray<T> atomicReferenceArray;

    public AtomicReferenceArrayListAdapter(AtomicReferenceArray<T> atomicReferenceArray) {
        this.atomicReferenceArray = atomicReferenceArray;
    }

    @Override
    public T get(int index) {
        return atomicReferenceArray.get(index);
    }

    @Override
    public int size() {
        return atomicReferenceArray.length();
    }
}
