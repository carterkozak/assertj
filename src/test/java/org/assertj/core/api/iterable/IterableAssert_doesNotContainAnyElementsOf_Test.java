/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2015 the original author or authors.
 */
package org.assertj.core.api.iterable;

import org.assertj.core.api.AbstractIterableAssert;
import org.assertj.core.api.ConcreteIterableAssert;
import org.assertj.core.api.IterableAssertBaseTest;

import static org.mockito.Mockito.verify;
import static org.assertj.core.util.Lists.newArrayList;

/**
 * Tests for <code>{@link AbstractIterableAssert#doesNotContainAnyElementsOf(Iterable)}</code>.
 * 
 * @author William Delanoue
 */
public class IterableAssert_doesNotContainAnyElementsOf_Test extends IterableAssertBaseTest {

  private final Iterable<String> values = newArrayList("Yoda", "Luke");

  @Override
  protected ConcreteIterableAssert<Object> invoke_api_method() {
    return assertions.doesNotContainAnyElementsOf(values);
  }

  @Override
  protected void verify_internal_effects() {
    verify(iterables).assertDoesNotContainAnyElementsOf(getInfo(assertions), getActual(assertions), values);
  }
}