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
package org.assertj.core.api.shortarray;

import static junit.framework.Assert.assertSame;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Comparator;


import org.assertj.core.api.ShortArrayAssert;
import org.assertj.core.api.ShortArrayAssertBaseTest;
import org.assertj.core.internal.Objects;
import org.assertj.core.internal.ShortArrays;
import org.junit.Before;
import org.mockito.Mock;

/**
 * Tests for <code>{@link ShortArrayAssert#usingDefaultComparator()}</code>.
 * 
 * @author Joel Costigliola
 * @author Mikhail Mazursky
 */
public class ShortArrayAssert_usingDefaultComparator_Test extends ShortArrayAssertBaseTest {

  @Mock
  private Comparator<short[]> comparator;

  private ShortArrays arraysBefore;

  @Before
  public void before() {
    initMocks(this);
    assertions.usingComparator(comparator);
    arraysBefore = getArrays(assertions);
  }

  @Override
  protected ShortArrayAssert invoke_api_method() {
    return assertions.usingDefaultComparator();
  }

  @Override
  protected void verify_internal_effects() {
    assertSame(getObjects(assertions), Objects.instance());
    assertSame(getArrays(assertions), arraysBefore);
  }
}