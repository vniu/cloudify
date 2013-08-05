/*******************************************************************************
 * Copyright (c) 2012 GigaSpaces Technologies Ltd. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.cloudifysource.utilitydomain.context.kvstore;

import org.cloudifysource.domain.context.kvstorage.AttributesFacade;
import org.cloudifysource.utilitydomain.kvstorage.spaceentries.GlobalCloudifyAttribute;

/**
 * @author Avishai Ish-Shalom
 * @since 2.1
 */
public class GlobalAttributesAccessor extends AbstractAttributesAccessor {

	public GlobalAttributesAccessor(final AttributesFacade attributesFacade) {
		super(attributesFacade, null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.cloudifysource.dsl.context.kvstorage.AbstractAttributesAccessor#prepareAttributeTemplate()
	 */
	@Override
	protected GlobalCloudifyAttribute prepareAttributeTemplate() {
		return new GlobalCloudifyAttribute();
	}

}