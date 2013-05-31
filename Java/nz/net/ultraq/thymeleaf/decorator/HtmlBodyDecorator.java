/*
 * Copyright 2013, Emanuel Rabina (http://www.ultraq.net.nz/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nz.net.ultraq.thymeleaf.decorator;

import static nz.net.ultraq.thymeleaf.decorator.DecoratorUtilities.*;

import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Text;

/**
 * A decorator specific to processing an HTML &lt;body&gt; element.
 * 
 * @author Emanuel Rabina
 */
public class HtmlBodyDecorator extends StandardDecorator {

	/**
	 * Decorate the BODY part.  This step merges the decorator and page BODY
	 * attributes, ensuring only that a BODY element actually exists in the
	 * result.  The bulk of the body decoration is actually performed by the
	 * fragment replacements.
	 * 
	 * @param decoratorhtml Decorator's HTML element.
	 * @param pagebody		Page's BODY element.
	 */
	@Override
	public void decorate(Element decoratorhtml, Element pagebody) {

		// If the page has no BODY, then we don't need to do anything
		if (pagebody == null) {
			return;
		}

		// If the decorator has no BODY, we can just copy the page BODY
		Element decoratorbody = findElement(decoratorhtml, HTML_ELEMENT_BODY);
		if (decoratorbody == null) {
			decoratorhtml.addChild(pagebody);
			decoratorhtml.addChild(new Text(LINE_SEPARATOR));
			return;
		}

		super.decorate(decoratorbody, pagebody);
	}
}
