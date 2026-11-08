/*
 * Copyright 2026 Sona Interactive, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("unused")

package gg.sona.eos.`internal`

import kotlin.Int
import kotlin.Long
import kotlin.LongArray
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.invoke
import kotlinx.cinterop.toCPointer

internal fun invokeNative(
  signature: String,
  function: Long,
  bits: LongArray,
): Long = when (signature) {
  "II_I" -> function.toCPointer<CFunction<(Int, Int) -> Int>>()!!.invoke(bits[0].toInt(), bits[1].toInt()).toLong()
  "I_I" -> function.toCPointer<CFunction<(Int) -> Int>>()!!.invoke(bits[0].toInt()).toLong()
  "I_J" -> function.toCPointer<CFunction<(Int) -> Long>>()!!.invoke(bits[0].toInt())
  "JIJJ_I" -> function.toCPointer<CFunction<(
        Long,
        Int,
        Long,
        Long,
      ) -> Int>>()!!.invoke(bits[0], bits[1].toInt(), bits[2], bits[3]).toLong()
  "JI_I" -> function.toCPointer<CFunction<(Long, Int) -> Int>>()!!.invoke(bits[0], bits[1].toInt()).toLong()
  "JI_J" -> function.toCPointer<CFunction<(Long, Int) -> Long>>()!!.invoke(bits[0], bits[1].toInt())
  "JJI_J" -> function.toCPointer<CFunction<(
        Long,
        Long,
        Int,
      ) -> Long>>()!!.invoke(bits[0], bits[1], bits[2].toInt())
  "JJJJJJJ_I" -> function.toCPointer<CFunction<(
        Long,
        Long,
        Long,
        Long,
        Long,
        Long,
        Long,
      ) -> Int>>()!!.invoke(bits[0], bits[1], bits[2], bits[3], bits[4], bits[5], bits[6]).toLong()
  "JJJJ_I" -> function.toCPointer<CFunction<(
        Long,
        Long,
        Long,
        Long,
      ) -> Int>>()!!.invoke(bits[0], bits[1], bits[2], bits[3]).toLong()
  "JJJJ_J" -> function.toCPointer<CFunction<(
        Long,
        Long,
        Long,
        Long,
      ) -> Long>>()!!.invoke(bits[0], bits[1], bits[2], bits[3])
  "JJJJ_V" -> function.toCPointer<CFunction<(
        Long,
        Long,
        Long,
        Long,
      ) -> Unit>>()!!.invoke(bits[0], bits[1], bits[2], bits[3]).let { 0L }
  "JJJ_I" -> function.toCPointer<CFunction<(
        Long,
        Long,
        Long,
      ) -> Int>>()!!.invoke(bits[0], bits[1], bits[2]).toLong()
  "JJ_I" -> function.toCPointer<CFunction<(Long, Long) -> Int>>()!!.invoke(bits[0], bits[1]).toLong()
  "JJ_J" -> function.toCPointer<CFunction<(Long, Long) -> Long>>()!!.invoke(bits[0], bits[1])
  "JJ_V" -> function.toCPointer<CFunction<(Long, Long) -> Unit>>()!!.invoke(bits[0], bits[1]).let { 0L }
  "J_I" -> function.toCPointer<CFunction<(Long) -> Int>>()!!.invoke(bits[0]).toLong()
  "J_J" -> function.toCPointer<CFunction<(Long) -> Long>>()!!.invoke(bits[0])
  "J_V" -> function.toCPointer<CFunction<(Long) -> Unit>>()!!.invoke(bits[0]).let { 0L }
  "_I" -> function.toCPointer<CFunction<() -> Int>>()!!.invoke().toLong()
  "_J" -> function.toCPointer<CFunction<() -> Long>>()!!.invoke()
  else -> throw UnsupportedOperationException("""No native invoker for the signature $signature""")
}
