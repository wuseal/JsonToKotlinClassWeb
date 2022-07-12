import kotlinx.serialization.Serializable

@Serializable
open class GenerateRequest(
    val json: String,
    val className: String,
    val annotationLib: String? = null, // MOSHI_CODE_GEN
    val defaultValueStrategy: String? = null, // AVOID_NULL
    val propertyTypeStrategy: String? = null, // AUTO_DETERMINE_NULLABLE_OR_NOT
    val indent: Int? = null, // 4
    val commentsEnabled: Boolean? = null, // true
    val createAnnotationOnlyWhenNeededEnabled: Boolean? = null, // true
    val enableVarProperties: Boolean? = null, // false
    val forceInitDefaultValueWithOriginJsonValueEnabled: Boolean? = null, // true
    val forcePrimitiveTypeNonNullableEnabled: Boolean? = null, // true
    val innerClassModelEnabled: Boolean? = null, // false
    val keepAnnotationOnClassAndroidXEnabled: Boolean? = null, // true
    val keepAnnotationOnClassEnabled: Boolean? = null, // true
    val mapTypeEnabled: Boolean? = null, // true
    val orderByAlphabeticEnabled: Boolean? = null, // true
    val parcelableSupportEnabled: Boolean? = null, // true
    val propertyAndAnnotationInSameLineEnabled: Boolean? = null, // true
    val packageName: String? = null, // com.my.package.name
    val parentClassTemplate: String? = null, // android.os.Parcelable
    val propertyPrefix: String? = null, // MY_PREFIX
    val classSuffix: String? = null, // MY_CLASS_SUFFIX
    val propertySuffix: String? = null // MY_SUFFIX
)