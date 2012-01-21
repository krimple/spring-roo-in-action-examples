package org.rooinaction.coursemanager.client.scaffold.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.ValueBox;

/**
 * A ValueBox that uses {@link ShortParser} and {@link ShortRenderer}.
 */
public class ShortBox extends ValueBox<Short> {

	public ShortBox() {
		super(Document.get().createTextInputElement(), ShortRenderer.instance(), ShortParser.instance());
	}
}