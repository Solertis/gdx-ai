/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.ai.tests.pfa.tests.tiled;

import com.badlogic.gdx.ai.pfa.DefaultConnection;

/** A connection for a {@link TiledGraph}.
 * 
 * @author davebaol */
public class TiledConnection extends DefaultConnection<TiledNode> {

	static final float NON_DIAGONAL_COST = (float)Math.sqrt(2);

	TiledGraph worldMap;

	public TiledConnection (TiledGraph worldMap, TiledNode fromNode, TiledNode toNode) {
		super(fromNode, toNode);
		this.worldMap = worldMap;
	}

	@Override
	public float getCost () {
		if (worldMap.diagonal) return 1;
		return getToNode().x != worldMap.startNode.x && getToNode().y != worldMap.startNode.y ? NON_DIAGONAL_COST : 1;
	}
}
