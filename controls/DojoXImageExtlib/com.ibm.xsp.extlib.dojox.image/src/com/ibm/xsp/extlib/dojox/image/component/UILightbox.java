/*
 * © Copyright IBM Corp. 2013
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.ibm.xsp.extlib.dojox.image.component;

import javax.faces.component.UIComponentBase;
import javax.faces.el.ValueBinding;

public class UILightbox extends UIComponentBase {

	private static final String RENDERER_TYPE = "com.ibm.xsp.extlib.dojox.image.Lightbox"; //$NON-NLS-1$
	private static final String COMPONENT_FAMILY = "com.ibm.xsp.extlib.DojoXImage"; //$NON-NLS-1$	

	private String _href = null;
	private String _title = null;
	private String _innerHTML = null;

	public UILightbox() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getHref() {
		return (_href != null ? _href : getStringValue("href"));
	}

	public void setHref(String href) {
		_href = href;
	}

	public String getTitle() {
		return (_title != null ? _title : getStringValue("title"));
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getInnerHTML() {
		return (_innerHTML != null ? _innerHTML : getStringValue("innerHTML"));
	}

	public void setInnerHTML(String innerHTML) {
		this._innerHTML = innerHTML;
	}

	private String getStringValue(String propName) {
		ValueBinding vb = getValueBinding(propName);
		return vb != null ? (String) vb.getValue(getFacesContext()) : "";
	}
}
