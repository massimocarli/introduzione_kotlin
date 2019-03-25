package kotlinfromjava.annotations

annotation class MyAnnotation

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Repeatable
@MustBeDocumented
annotation class Annot


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class AnnotWithParams(val name: String, val enabled: Boolean = false)


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.PROPERTY)
annotation class Prop(val name: String)


@Annot
class Annotated() {

    @Annot
    fun annotatedFunction() {
    }
}

@AnnotWithParams("withParam", false)
interface AnnWithParam


class WithPros(
    @Prop("n") val name: String,
    @Prop("a") val age: Int,
    @Prop("e") val enabled: Boolean
)
