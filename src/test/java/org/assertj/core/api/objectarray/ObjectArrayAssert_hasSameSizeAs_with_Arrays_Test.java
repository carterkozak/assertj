/*
 * Created on Apr 27, 2012
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance
 * with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 * on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2010-2012 the original author or authors.
 */
package org.assertj.core.api.objectarray;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.error.ShouldHaveSameSizeAs.shouldHaveSameSizeAs;
import static org.assertj.core.test.ExpectedException.none;
import static org.assertj.core.test.TestFailures.failBecauseExpectedAssertionErrorWasNotThrown;
import static org.assertj.core.util.Arrays.array;
import static org.assertj.core.util.FailureMessages.actualIsNull;

import org.junit.Rule;
import org.junit.Test;

import org.assertj.core.test.ExpectedException;


/**
 * Tests for <code>{@link ObjectArrayAssert#hasSameSizeAs(Object))}</code>.
 *
 * @author Joel Costigliola
 */
public class ObjectArrayAssert_hasSameSizeAs_with_Arrays_Test {

  @Rule
  public ExpectedException thrown = none();

  @Test
  public void should_pass_if_actual_object_array_has_same_size_as_other_object_array() {
    assertThat(new String[]{"1", "2"}).hasSameSizeAs(new Byte[]{2, 3});
    assertThat(new String[]{"1", "2"}).hasSameSizeAs(new String[]{"1", "2"});
  }

  @Test
  public void should_pass_if_actual_object_array_has_same_size_as_other_primitive_array() {
    assertThat(new String[]{"1", "2"}).hasSameSizeAs(new byte[]{2, 3});
    assertThat(new String[]{"1", "2"}).hasSameSizeAs(new int[]{2, 3});
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    final String[] actual = null;
    assertThat(actual).hasSameSizeAs(new String[]{"1"});
  }

  @Test
  public void should_fail_if_other_is_not_an_array() {
    thrown.expectAssertionError("Expecting an array but was:<\"a string\">");
    assertThat(new byte[]{1, 2}).hasSameSizeAs("a string");
  }

  @Test
  public void should_fail_if_size_of_actual_has_same_as_other_array() {
    final String[] actual = array("Luke", "Yoda");
    final String[] other = array("Yoda");
    try {
      assertThat(actual).hasSameSizeAs(other);
    } catch (AssertionError e) {
      assertThat(e).hasMessage(shouldHaveSameSizeAs(actual, actual.length, other.length).create());
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }
}