/*
 * Copyright (c) 2018, https://runelitepl.us
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.equipmentinspector;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.api.ItemComposition;
import net.runelite.api.kit.KitType;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import org.apache.commons.lang3.StringUtils;

class ItemPanel extends JPanel
{
	ItemPanel(ItemComposition item, KitType kitType, AsyncBufferedImage icon)
	{

        setBorder(new EmptyBorder(3, 3, 3, 3));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);

		JLabel name = new JLabel(item.getName());

		JLabel location = new JLabel(StringUtils.capitalize(kitType.toString().toLowerCase()));
		location.setFont(FontManager.getRunescapeSmallFont());

		JLabel imageLabel = new JLabel();
		icon.addTo(imageLabel);

		layout.setVerticalGroup(layout.createParallelGroup()
				.addComponent(imageLabel)
				.addGroup(layout.createSequentialGroup()
						.addComponent(name)
						.addComponent(location)
				)
		);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(imageLabel)
				.addGap(8)
				.addGroup(layout.createParallelGroup()
						.addComponent(name)
						.addComponent(location)
				)
		);

		// AWT's Z order is weird. This put image at the back of the stack
		setComponentZOrder(imageLabel, getComponentCount() - 1);
	}
}