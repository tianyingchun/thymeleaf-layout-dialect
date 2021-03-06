/*
 * Copyright 2012, Emanuel Rabina (http://www.ultraq.net.nz/)
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

package nz.net.ultraq.thymeleaf;

import nz.net.ultraq.thymeleaf.decorator.DecoratorProcessor;
import nz.net.ultraq.thymeleaf.decorator.TitlePatternProcessor;
import nz.net.ultraq.thymeleaf.include.IncludeProcessor;
import nz.net.ultraq.thymeleaf.include.ReplaceProcessor;
import nz.net.ultraq.thymeleaf.include.SubstituteByProcessor;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

import java.util.HashSet;
import java.util.Set;

/**
 * Dialect for making use of template/layout decorator pages with Thymeleaf.
 * 
 * @author Emanuel Rabina
 */
public class LayoutDialect extends AbstractDialect {

	public static final String DIALECT_NAMESPACE_LAYOUT = "http://www.ultraq.net.nz/thymeleaf/layout";
	public static final String DIALECT_PREFIX_LAYOUT    = "layout";

	/**
	 * Return the layout prefix.
	 * 
	 * @return <tt>layout</tt>
	 */
	@Override
	public String getPrefix() {

		return DIALECT_PREFIX_LAYOUT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<IProcessor> getProcessors() {

		HashSet<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new DecoratorProcessor());
		processors.add(new IncludeProcessor());
		processors.add(new ReplaceProcessor());
		processors.add(new SubstituteByProcessor());
		processors.add(new FragmentProcessor());
		processors.add(new TitlePatternProcessor());
		return processors;
	}
}
