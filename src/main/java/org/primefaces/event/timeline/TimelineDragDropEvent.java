/**
 * Copyright 2009-2019 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.event.timeline;

import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;

public class TimelineDragDropEvent extends TimelineAddEvent {

    private static final long serialVersionUID = 1L;

    /**
     * client ID of the dragged component
     */
    private String dragId;

    /**
     * dragged model object if draggable item is within a data iteration component or null
     */
    private Object data;

    public TimelineDragDropEvent(UIComponent component, Behavior behavior, Date startDate, Date endDate, String group,
            String dragId, Object data) {
        super(component, behavior, startDate, endDate, group);
        this.dragId = dragId;
        this.data = data;
    }

    public String getDragId() {
        return dragId;
    }

    public Object getData() {
        return data;
    }
}
