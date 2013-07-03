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

package com.ibm.xsp.extlib.dojox.image.renderkit.html_basic;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import com.ibm.xsp.component.UIViewRootEx;
import com.ibm.xsp.extlib.dojox.image.component.UILightbox;
import com.ibm.xsp.resource.DojoModuleResource;
import com.ibm.xsp.resource.StyleSheetResource;


public class LightboxRenderer extends Renderer {

	private static final String LIGHTBOX_DOJOTYPE = "dojox.image.Lightbox";
	private static final String LIGHTBOX_CSS = "/.ibmxspres/dojoroot/dojox/image/resources/Lightbox.css";

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();

		UIViewRootEx rootEx = (UIViewRootEx) context.getViewRoot();
		rootEx.setDojoParseOnLoad(true);
		rootEx.setDojoTheme(true);
		rootEx.addEncodeResource(new DojoModuleResource(LIGHTBOX_DOJOTYPE));
		rootEx.addEncodeResource(new StyleSheetResource(LIGHTBOX_CSS));

		UILightbox lightboxComp = (UILightbox) component;
		writer.startElement("a", component);
		writer.writeAttribute("dojotype", LIGHTBOX_DOJOTYPE, null);
		writer.writeAttribute("href", lightboxComp.getHref(), null);
		writer.writeAttribute("title", lightboxComp.getTitle(), null);
		writer.write(lightboxComp.getInnerHTML());
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.endElement("a");
	}
}
