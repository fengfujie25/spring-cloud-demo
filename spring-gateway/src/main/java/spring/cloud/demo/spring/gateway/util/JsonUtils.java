package spring.cloud.demo.spring.gateway.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @auther: fujie.feng
 * @DateT: 2019-11-03
 */
public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private JsonUtils() {
    }

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        //objectMapper.configure(JsonParser.Feature.IGNORE_UNDEFINED, true);
        objectMapper.getFactory().configure(JsonFactory.Feature.INTERN_FIELD_NAMES, true);
        objectMapper.getFactory().configure(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);// 属性为null不参与序列化

        SimpleModule module = new SimpleModule("DateTimeModule", Version.unknownVersion());
        module.addDeserializer(Timestamp.class, new JsonDeserializer<Timestamp>() {
            @Override
            public Timestamp deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
//                String date = jsonParser.getText();
//                return Strings.isNullOrEmpty(date) ? null : new Timestamp(DateFormatUtil.parse4y2m2d2H2M2S(date)
//                        .getTime());
                return null;
            }
        });
        module.addDeserializer(Date.class, new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                    throws IOException, JsonProcessingException {
//                String date = jsonParser.getText();
//                return Strings.isNullOrEmpty(date) ? null : new Date(DateFormatUtil.parse4y2m2d2H2M2S(date).getTime());
                return null;
            }
        });
        module.addSerializer(Timestamp.class, new JsonSerializer<Timestamp>() {
            @Override
            public void serialize(Timestamp date, JsonGenerator jsonGenerator, SerializerProvider provider)
                    throws IOException {
//                jsonGenerator.writeString(date != null ? DateFormatUtil.format4m2d2h2m2s2WithMinus(date) : "null");
            }
        });
        module.addSerializer(Date.class, new JsonSerializer<Date>() {
            @Override
            public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                    throws IOException, JsonProcessingException {
//                jsonGenerator.writeString(date != null ? DateFormatUtil.format4m2d2h2m2s2WithMinus(date) : "null");
            }
        });
        objectMapper.registerModule(module);
    }

    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    public static String toString(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            logger.error("JsonUtil.toString error", e);
            return null;
        }
    }

    public static <T> T parseJson(String json, Class<T> tClass) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, tClass);
        } catch (IOException e) {
            logger.error("json parse error", e);
            return null;
        }
    }

    public static <T> T parseJsonOfType(String json, TypeReference<T> reference) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, reference);
        } catch (IOException e) {
            logger.error("json parse error", e);
            return null;
        }
    }
}
