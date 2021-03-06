/*
 * Copyright 2014 mango.jfaster.org
 *
 * The Mango Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.jfaster.mango.binding;

import org.jfaster.mango.base.Objects;
import org.jfaster.mango.base.Strings;

/**
 * @author ash
 */
public class BindingParameter {

  private final String parameterName;

  private final String propertyPath;

  private BindingParameter(String parameterName, String propertyPath) {
    this.parameterName = parameterName;
    this.propertyPath = propertyPath;
  }

  public static BindingParameter create(String parameterName) {
    return new BindingParameter(parameterName, "");
  }

  public static BindingParameter create(String parameterName, String propertyPath) {
    return new BindingParameter(parameterName, propertyPath);
  }

  public BindingParameter rightShift() {
    String newPropertyPath = Strings.isNotEmpty(propertyPath) ?
        parameterName + "." + propertyPath :
        parameterName;
    return BindingParameter.create("", newPropertyPath);
  }

  public String getParameterName() {
    return parameterName;
  }

  public String getPropertyPath() {
    return propertyPath;
  }

  public String getFullName() {
    return Strings.getFullName(parameterName, propertyPath);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final BindingParameter other = (BindingParameter) obj;
    return Objects.equal(this.getParameterName(), other.getParameterName())
        && Objects.equal(this.getPropertyPath(), other.getPropertyPath());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getParameterName(), getPropertyPath());
  }

  @Override
  public String toString() {
    return getFullName();
  }

}
