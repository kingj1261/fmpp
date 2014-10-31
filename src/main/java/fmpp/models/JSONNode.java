package fmpp.models;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import fmpp.util.StringUtil;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNodeModel;

/**
 * Node in a hierarchy of JSON values. See http://www.json.org/ for JSON types; each has its own subclass.
 * JSON "object" and "array" values are the non-leafs in the tree.
 */
public abstract class JSONNode implements TemplateNodeModel, Serializable {
    
    private static final long serialVersionUID = 1L;

    private final JSONNode parentNode;
    private final String nodeName;

    /**
     * Returns the FTL node name for a node that has otherwise no name.
     */
    protected static String nodeTypeToDefaultNodeName(String nodeType) {
        return "nameless" + StringUtil.capitalizeFirst(nodeType);        
    }

    /**
     * @param parentNode the JSON "object" or JSON "array" that contains this value.
     * @param nodeName {@code null}, unless this is the value in a key-value pair, in which case it's the key.
     */
    protected JSONNode(JSONNode parentNode, String nodeName) {
        this.parentNode = parentNode;
        this.nodeName = nodeName;
    }
    
    /**
     * Returns the JSON "object" or JSON "array" that contains this value.
     */
    public final TemplateNodeModel getParentNode() throws TemplateModelException {
        return parentNode;
    }

    /**
     * Returns the same as {@link #getNodeType()}, except when the node is the value in a key-value pair in a
     * JSON object, in which case it returns the key value.
     */
    public final String getNodeName() throws TemplateModelException {
        return nodeName;
    }

    public final String getNodeNamespace() throws TemplateModelException {
        return null;
    }

    /**
     * Wraps a {@link List}, a {@link Map} with string keys, a {@link String}, a {@link Number} or a {@link Boolean}
     * into a {@link JSONNode}. The values in the {@link List} or {@link Map} must be also be one of the previously
     * listed types. The resulting object is NOT thread safe. Also, the wrapped objects shouldn't be changed after the
     * wrapping. The wrapping of the contained values is possibly lazy.
     */
    public static JSONNode wrap(Object jsonPOJO) {
        return wrap(jsonPOJO, null, null); 
    }
    
    /**
     * @param parentNode Same as the similar parameter of {@link #JSONNode(JSONNode, String)}.
     * @param nodeName Same as the similar parameter of {@link #JSONNode(JSONNode, String)}.
     */
    protected static JSONNode wrap(Object obj, JSONNode parentNode, String nodeName) {
        if (obj == null) return null;
        
        return null;  // TODO
    }

}