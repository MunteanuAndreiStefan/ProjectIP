package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonTag
{
    private boolean hasParent = false;
    private JsonParamType type = JsonParamType.none;
    private int intValue;

    private String name;

    private String stringValue;
    private List<JsonTag> tags = null;

    public void setName(String name)
    {
        this.name = name;
    }

    public JsonTag(String name, String value)
    {
        type = JsonParamType.stringType;
        stringValue = value;
        this.name = name;
    }

    public JsonTag(String name, int value)
    {
        type = JsonParamType.intType;
        intValue = value;
        this.name = name;
    }

    public JsonTag(String name, JsonTag... tags)
    {
        this.name = name;
        type = JsonParamType.vector;
        this.tags = new ArrayList<>();
        for (JsonTag tag : tags)
            this.tags.add(tag.setHasParent(true));
    }

    public JsonTag(JsonTag... tags)
    {
        type = JsonParamType.vector;
        this.tags = new ArrayList<>();
        for (JsonTag tag : tags)
            this.tags.add(tag.setHasParent(true));
    }

    public JsonTag(String name)
    {
        this.name = name;
        type = JsonParamType.vector;
    }

    public void appendTag(JsonTag tag)
    {
        this.name = name;
        if (tags == null)
        {
            assert type == JsonParamType.none;
            tags = new ArrayList<>();
            type = JsonParamType.vector;
        }
        tags.add(tag.setHasParent(true));
    }

    public void appendTag(String name, String value)
    {
        assert type == JsonParamType.stringType;
        this.appendTag(new JsonTag(name, value).setHasParent(true));
    }

    public void appendTag(String name, int value)
    {
        assert type == JsonParamType.intType;
        this.appendTag(new JsonTag(name, value).setHasParent(true));
    }

    public JsonTag setHasParent(boolean hasParent)
    {
        this.hasParent = hasParent;
        return this;
    }

    public int getIntValue()
    {
        return intValue;
    }

    public String getStringValue()
    {
        return stringValue;
    }

    public String exportToJSON()
    {
        assert type == JsonParamType.none;
        StringBuilder result = new StringBuilder();
        if (!hasParent)
            result.append("{\n");

        switch (type)
        {
            case intType:
                result.append("\"").append(name).append("\" : ").append(String.valueOf(intValue)).append("\n");
                break;
            case stringType:
                result.append("\"").append(name).append("\" : \"").append(stringValue).append("\"\n");
                break;
            case vector:
                if (hasParent)
                    result.append(name).append(" : {\n");
                for (int i = 0; i < tags.size(); i++)
                {
                    result.append(tags.get(i).setHasParent(true).exportToJSON());
                    if (i != tags.size()-1)
                        result.append(",");
                }
                if (hasParent)
                    result.append("}\n");
        }

        if (!hasParent)
            result.append("}\n");

        return result.toString();
    }
}
