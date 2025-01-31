## jsonoy - JSON Encoder

JSON Encoder through Reflection API.

## DEADLINES

1. **03-03-2025**
1. **10-03-2025**

***

Use this project as the template for your implementation of a JSON Encoder.

## 1. `fieldsToJson` 

Implement the extension function `fieldsToJson` (in `FieldsToJson.kt`), which
converts the declared fields of a given object to JSON. This function should use
the Java Reflection API to inspect fields and recursively process non-primitive
types.

Your implementation should pass both `testAddressFieldsToJson()` and
`testClassroomFieldsToJson()` tests.

## 2. `membersToJson`

Implement the extension function `membersToJson` (in `MembersToJson.kt`) using
the Kotlin Reflection API.  
This function encodes properties and non-void parameterless functions.  
The `membersToJson` function must be recursive.

- Members can be annotated with `ToJsonPropName` to replace the member's name
  with the specified JSON property name.
- Members can also be annotated with `ToJsonFormatter`, which specifies a class
  implementing a function `(Any) -> String`. This function provides an
  alternative JSON representation of the member's value, processing it.
