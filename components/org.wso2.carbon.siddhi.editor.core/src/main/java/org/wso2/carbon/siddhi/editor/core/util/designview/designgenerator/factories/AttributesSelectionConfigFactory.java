/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.siddhi.editor.core.util.designview.designgenerator.factories;

import org.wso2.carbon.siddhi.editor.core.util.designview.beans.configs.siddhielements.attributesselection.AllSelectionConfig;
import org.wso2.carbon.siddhi.editor.core.util.designview.beans.configs.siddhielements.attributesselection.AttributesSelectionConfig;
import org.wso2.carbon.siddhi.editor.core.util.designview.beans.configs.siddhielements.attributesselection.SelectedAttribute;
import org.wso2.carbon.siddhi.editor.core.util.designview.beans.configs.siddhielements.attributesselection.UserDefinedSelectionConfig;
import org.wso2.carbon.siddhi.editor.core.util.designview.constants.AttributeSelection;

import java.util.List;

/**
 * Factory to create an AttributesSelectionConfig
 */
public class AttributesSelectionConfigFactory {
    /**
     * Gets config object for user defined selection attributes, from the given list of SelectedAttributeConfigs
     * @param selectedAttributes    List of SelectedAttributes, that are user-defined selections
     * @return                      UserDefinedSelectionConfig object
     */
    public AttributesSelectionConfig getAttributesSelectionConfig(List<SelectedAttribute> selectedAttributes) {
        return new UserDefinedSelectionConfig(selectedAttributes);
    }

    /**
     * Gets config object for select all attributes
     * @param type  Type of attribute selection. Only {AttributeSelection.VALUE_ALL} can be given
     * @return      AllSelectionConfig
     */
    public AttributesSelectionConfig getAttributesSelectionConfig(String type) {
        if (type.equalsIgnoreCase(AttributeSelection.VALUE_ALL)) {
            return new AllSelectionConfig();
        }
        throw new IllegalArgumentException("Cannot find matching class for selection type " + type);
    }
}
