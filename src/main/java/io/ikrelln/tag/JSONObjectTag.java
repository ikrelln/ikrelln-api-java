package io.ikrelln.tag;

import io.opentracing.Span;
import io.opentracing.tag.AbstractTag;
import org.json.JSONObject;

public class JSONObjectTag extends AbstractTag<JSONObject> {

    public JSONObjectTag(String key) {
        super(key);
    }

    @Override
    public void set(Span span, JSONObject tagValue) {
        span.setTag(super.key, tagValue.toString());
    }

}
