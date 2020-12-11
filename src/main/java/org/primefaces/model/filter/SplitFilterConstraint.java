/*
 * The MIT License
 *
 * Copyright (c) 2009-2020 PrimeTek
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.primefaces.model.filter;

import org.primefaces.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SplitFilterConstraint implements FilterConstraint {

    public boolean applies(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase(locale);
        String valueText = (value == null) ? null : value.toString().trim().toLowerCase(locale);

        if (filterText == null || filterText.equals(Constants.EMPTY_STRING)) {
            return true;
        }
        if (valueText == null) {
            return false;
        }
        if (valueText.indexOf(",") > -1) {
            valueText = valueText.replace(",", "");
        }
        if (filterText.indexOf(",") > -1) {
            filterText = filterText.replace(",", "");
        }
        String[] valueSplits = valueText.split(" ");
        String[] filterSplits = filterText.split(" ");
        List<String> list = new ArrayList<String>();
        for (String valueSplit : valueSplits) {
            for (String filterSplit : filterSplits) {
                if (valueSplit.contains(filterSplit)) {
                    if (!list.contains(filterSplit)) {
                        list.add(filterSplit);
                        if (list.size() == filterSplits.length) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
