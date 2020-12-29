package properties

import java.util.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

fun MyDate.toMillis(): Long {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth, 0, 0, 0)
    c.set(Calendar.MILLISECOND, 0)
    return c.timeInMillis
}

fun Long.toDate(): MyDate {
    val c = Calendar.getInstance()
    c.timeInMillis = this
    return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
}

class D {
    var date: MyDate by EffectDate()
}

class EffectDate<D> : ReadWriteProperty<D, MyDate> {
    var timeInMillis: Long? = null
    override fun getValue(thisRef: D, property: KProperty<*>): MyDate {
        return timeInMillis!!.toDate()
    }

    override fun setValue(thisRef: D, property: KProperty<*>, value: MyDate) {
        timeInMillis = value.toMillis()
    }
}
