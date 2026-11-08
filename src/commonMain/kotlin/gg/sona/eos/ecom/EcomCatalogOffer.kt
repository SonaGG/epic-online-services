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
package gg.sona.eos.ecom

class EcomCatalogOffer(
    val id: String,
    val title: String,
    val description: String,
    val longDescription: String,
    val technicalDetails: String,
    val currencyCode: String,
    val numericPrice: Int,
    val originalNumericPrice: Int,
    val currentPrice64: Long,
    val originalPrice64: Long,
    val discountPercent: Int,
    val expirationDate: Long,
    val availableForPurchase: Boolean,
    val availableForEntitlement: Boolean,
    val itemCount: Int,
)
