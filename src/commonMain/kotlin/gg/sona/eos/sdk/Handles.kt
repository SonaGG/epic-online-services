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
@file:Suppress("unused", "FunctionName", "PropertyName")

package gg.sona.eos.sdk

import gg.sona.eos.EosException
import gg.sona.eos.EosResult
import gg.sona.eos.`internal`.CallbackStubs
import gg.sona.eos.`internal`.Native
import gg.sona.eos.`internal`.RawMemory
import gg.sona.eos.`internal`.foreign.Arena
import gg.sona.eos.`internal`.foreign.MemorySegment
import gg.sona.eos.`internal`.foreign.ValueLayout
import gg.sona.eos.common.ContinuanceToken
import gg.sona.eos.common.EpicAccountId
import gg.sona.eos.common.ProductUserId
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmInline

@JvmInline
public value class HAchievements(
  public val handle: Long,
) {
  public fun queryDefinitions(options: AchievementsQueryDefinitionsOptions, completionDelegate: (AchievementsOnQueryDefinitionsCompleteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AchievementsOnQueryDefinitionsCompleteCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_Achievements_QueryDefinitions", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getAchievementDefinitionCount(options: AchievementsGetAchievementDefinitionCountOptions): Int = (Native.invoke("EOS_Achievements_GetAchievementDefinitionCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyAchievementDefinitionV2ByIndex(options: AchievementsCopyAchievementDefinitionV2ByIndexOptions): AchievementsDefinitionV2 = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Achievements_CopyAchievementDefinitionV2ByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    AchievementsDefinitionV2(RawMemory.getLong(out))
  }

  public fun copyAchievementDefinitionV2ByAchievementId(options: AchievementsCopyAchievementDefinitionV2ByAchievementIdOptions): AchievementsDefinitionV2 = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Achievements_CopyAchievementDefinitionV2ByAchievementId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    AchievementsDefinitionV2(RawMemory.getLong(out))
  }

  public fun queryPlayerAchievements(options: AchievementsQueryPlayerAchievementsOptions, completionDelegate: (AchievementsOnQueryPlayerAchievementsCompleteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AchievementsOnQueryPlayerAchievementsCompleteCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_Achievements_QueryPlayerAchievements", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getPlayerAchievementCount(options: AchievementsGetPlayerAchievementCountOptions): Int = (Native.invoke("EOS_Achievements_GetPlayerAchievementCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyPlayerAchievementByIndex(options: AchievementsCopyPlayerAchievementByIndexOptions): AchievementsPlayerAchievement = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Achievements_CopyPlayerAchievementByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    AchievementsPlayerAchievement(RawMemory.getLong(out))
  }

  public fun copyPlayerAchievementByAchievementId(options: AchievementsCopyPlayerAchievementByAchievementIdOptions): AchievementsPlayerAchievement = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Achievements_CopyPlayerAchievementByAchievementId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    AchievementsPlayerAchievement(RawMemory.getLong(out))
  }

  public fun unlockAchievements(options: AchievementsUnlockAchievementsOptions, completionDelegate: (AchievementsOnUnlockAchievementsCompleteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AchievementsOnUnlockAchievementsCompleteCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_Achievements_UnlockAchievements", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun addNotifyAchievementsUnlockedV2(options: AchievementsAddNotifyAchievementsUnlockedV2Options, notificationFn: (AchievementsOnAchievementsUnlockedCallbackV2Info) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AchievementsOnAchievementsUnlockedCallbackV2Info(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Achievements_AddNotifyAchievementsUnlockedV2", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyAchievementsUnlocked(inId: Long) {
    Native.invokeVoid("EOS_Achievements_RemoveNotifyAchievementsUnlocked", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun copyAchievementDefinitionByIndex(options: AchievementsCopyAchievementDefinitionByIndexOptions): AchievementsDefinition = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Achievements_CopyAchievementDefinitionByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    AchievementsDefinition(RawMemory.getLong(out))
  }

  public fun copyAchievementDefinitionByAchievementId(options: AchievementsCopyAchievementDefinitionByAchievementIdOptions): AchievementsDefinition = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Achievements_CopyAchievementDefinitionByAchievementId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    AchievementsDefinition(RawMemory.getLong(out))
  }

  public fun getUnlockedAchievementCount(options: AchievementsGetUnlockedAchievementCountOptions): Int = (Native.invoke("EOS_Achievements_GetUnlockedAchievementCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyUnlockedAchievementByIndex(options: AchievementsCopyUnlockedAchievementByIndexOptions): AchievementsUnlockedAchievement = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Achievements_CopyUnlockedAchievementByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    AchievementsUnlockedAchievement(RawMemory.getLong(out))
  }

  public fun copyUnlockedAchievementByAchievementId(options: AchievementsCopyUnlockedAchievementByAchievementIdOptions): AchievementsUnlockedAchievement = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Achievements_CopyUnlockedAchievementByAchievementId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    AchievementsUnlockedAchievement(RawMemory.getLong(out))
  }

  public fun addNotifyAchievementsUnlocked(options: AchievementsAddNotifyAchievementsUnlockedOptions, notificationFn: (AchievementsOnAchievementsUnlockedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AchievementsOnAchievementsUnlockedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Achievements_AddNotifyAchievementsUnlocked", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public companion object {
    public val NULL: HAchievements = HAchievements(0)
  }
}

@JvmInline
public value class HActiveSession(
  public val handle: Long,
) {
  public fun copyInfo(options: ActiveSessionCopyInfoOptions): ActiveSessionInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_ActiveSession_CopyInfo", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    ActiveSessionInfo(RawMemory.getLong(out))
  }

  public fun getRegisteredPlayerCount(options: ActiveSessionGetRegisteredPlayerCountOptions): Int = (Native.invoke("EOS_ActiveSession_GetRegisteredPlayerCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getRegisteredPlayerByIndex(options: ActiveSessionGetRegisteredPlayerByIndexOptions): ProductUserId = ProductUserId(Native.invoke("EOS_ActiveSession_GetRegisteredPlayerByIndex", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun release() {
    Native.invokeVoid("EOS_ActiveSession_Release", listOf(handle), listOf(ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HActiveSession = HActiveSession(0)
  }
}

@JvmInline
public value class HAntiCheatClient(
  public val handle: Long,
) {
  public fun addNotifyMessageToServer(options: AntiCheatClientAddNotifyMessageToServerOptions, notificationFn: (AntiCheatClientOnMessageToServerCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AntiCheatClientOnMessageToServerCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_AntiCheatClient_AddNotifyMessageToServer", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyMessageToServer(notificationId: Long) {
    Native.invokeVoid("EOS_AntiCheatClient_RemoveNotifyMessageToServer", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyMessageToPeer(options: AntiCheatClientAddNotifyMessageToPeerOptions, notificationFn: (AntiCheatCommonOnMessageToClientCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AntiCheatCommonOnMessageToClientCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_AntiCheatClient_AddNotifyMessageToPeer", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyMessageToPeer(notificationId: Long) {
    Native.invokeVoid("EOS_AntiCheatClient_RemoveNotifyMessageToPeer", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyPeerActionRequired(options: AntiCheatClientAddNotifyPeerActionRequiredOptions, notificationFn: (AntiCheatCommonOnClientActionRequiredCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AntiCheatCommonOnClientActionRequiredCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_AntiCheatClient_AddNotifyPeerActionRequired", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyPeerActionRequired(notificationId: Long) {
    Native.invokeVoid("EOS_AntiCheatClient_RemoveNotifyPeerActionRequired", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyPeerAuthStatusChanged(options: AntiCheatClientAddNotifyPeerAuthStatusChangedOptions, notificationFn: (AntiCheatCommonOnClientAuthStatusChangedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AntiCheatCommonOnClientAuthStatusChangedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_AntiCheatClient_AddNotifyPeerAuthStatusChanged", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyPeerAuthStatusChanged(notificationId: Long) {
    Native.invokeVoid("EOS_AntiCheatClient_RemoveNotifyPeerAuthStatusChanged", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyClientIntegrityViolated(options: AntiCheatClientAddNotifyClientIntegrityViolatedOptions, notificationFn: (AntiCheatClientOnClientIntegrityViolatedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AntiCheatClientOnClientIntegrityViolatedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_AntiCheatClient_AddNotifyClientIntegrityViolated", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyClientIntegrityViolated(notificationId: Long) {
    Native.invokeVoid("EOS_AntiCheatClient_RemoveNotifyClientIntegrityViolated", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun beginSession(options: AntiCheatClientBeginSessionOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_BeginSession", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun endSession(options: AntiCheatClientEndSessionOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_EndSession", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun pollStatus(
    options: AntiCheatClientPollStatusOptions,
    outViolationType: Long,
    outMessage: String?,
  ): EosResult = Arena.ofConfined().use { arena ->
    EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_PollStatus", listOf(handle, options.address, outViolationType, if (outMessage == null) 0L else arena.allocateFrom(outMessage).address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)
  }

  public fun reserved01(options: AntiCheatClientReserved01Options): Int = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_Reserved01", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RawMemory.getInt(out)
  }

  public fun reserved02(options: AntiCheatClientReserved02Options): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_Reserved02", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getModuleBuildId(options: AntiCheatClientGetModuleBuildIdOptions): Int = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_GetModuleBuildId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RawMemory.getInt(out)
  }

  public fun getSystemRequirementStatus(
    options: AntiCheatClientGetSystemRequirementStatusOptions,
    outRequirementStatus: Long,
    outReason: String?,
  ): EosResult = Arena.ofConfined().use { arena ->
    EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_GetSystemRequirementStatus", listOf(handle, options.address, outRequirementStatus, if (outReason == null) 0L else arena.allocateFrom(outReason).address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)
  }

  public fun addExternalIntegrityCatalog(options: AntiCheatClientAddExternalIntegrityCatalogOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_AddExternalIntegrityCatalog", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun receiveMessageFromServer(options: AntiCheatClientReceiveMessageFromServerOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_ReceiveMessageFromServer", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getProtectMessageOutputLength(options: AntiCheatClientGetProtectMessageOutputLengthOptions): Int = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_GetProtectMessageOutputLength", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RawMemory.getInt(out)
  }

  public fun protectMessage(
    options: AntiCheatClientProtectMessageOptions,
    outBuffer: Long,
    outBytesWritten: Long,
  ): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_ProtectMessage", listOf(handle, options.address, outBuffer, outBytesWritten), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun unprotectMessage(
    options: AntiCheatClientUnprotectMessageOptions,
    outBuffer: Long,
    outBytesWritten: Long,
  ): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_UnprotectMessage", listOf(handle, options.address, outBuffer, outBytesWritten), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun registerPeer(options: AntiCheatClientRegisterPeerOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_RegisterPeer", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun unregisterPeer(options: AntiCheatClientUnregisterPeerOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_UnregisterPeer", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun receiveMessageFromPeer(options: AntiCheatClientReceiveMessageFromPeerOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatClient_ReceiveMessageFromPeer", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public companion object {
    public val NULL: HAntiCheatClient = HAntiCheatClient(0)
  }
}

@JvmInline
public value class HAntiCheatServer(
  public val handle: Long,
) {
  public fun addNotifyMessageToClient(options: AntiCheatServerAddNotifyMessageToClientOptions, notificationFn: (AntiCheatCommonOnMessageToClientCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AntiCheatCommonOnMessageToClientCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_AntiCheatServer_AddNotifyMessageToClient", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyMessageToClient(notificationId: Long) {
    Native.invokeVoid("EOS_AntiCheatServer_RemoveNotifyMessageToClient", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyClientActionRequired(options: AntiCheatServerAddNotifyClientActionRequiredOptions, notificationFn: (AntiCheatCommonOnClientActionRequiredCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AntiCheatCommonOnClientActionRequiredCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_AntiCheatServer_AddNotifyClientActionRequired", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyClientActionRequired(notificationId: Long) {
    Native.invokeVoid("EOS_AntiCheatServer_RemoveNotifyClientActionRequired", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyClientAuthStatusChanged(options: AntiCheatServerAddNotifyClientAuthStatusChangedOptions, notificationFn: (AntiCheatCommonOnClientAuthStatusChangedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AntiCheatCommonOnClientAuthStatusChangedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_AntiCheatServer_AddNotifyClientAuthStatusChanged", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyClientAuthStatusChanged(notificationId: Long) {
    Native.invokeVoid("EOS_AntiCheatServer_RemoveNotifyClientAuthStatusChanged", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun beginSession(options: AntiCheatServerBeginSessionOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_BeginSession", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun endSession(options: AntiCheatServerEndSessionOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_EndSession", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun registerClient(options: AntiCheatServerRegisterClientOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_RegisterClient", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun unregisterClient(options: AntiCheatServerUnregisterClientOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_UnregisterClient", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun receiveMessageFromClient(options: AntiCheatServerReceiveMessageFromClientOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_ReceiveMessageFromClient", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setClientDetails(options: AntiCheatCommonSetClientDetailsOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_SetClientDetails", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setGameSessionId(options: AntiCheatCommonSetGameSessionIdOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_SetGameSessionId", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setClientNetworkState(options: AntiCheatServerSetClientNetworkStateOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_SetClientNetworkState", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getProtectMessageOutputLength(options: AntiCheatServerGetProtectMessageOutputLengthOptions): Int = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_GetProtectMessageOutputLength", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RawMemory.getInt(out)
  }

  public fun protectMessage(
    options: AntiCheatServerProtectMessageOptions,
    outBuffer: Long,
    outBytesWritten: Long,
  ): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_ProtectMessage", listOf(handle, options.address, outBuffer, outBytesWritten), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun unprotectMessage(
    options: AntiCheatServerUnprotectMessageOptions,
    outBuffer: Long,
    outBytesWritten: Long,
  ): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_UnprotectMessage", listOf(handle, options.address, outBuffer, outBytesWritten), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun registerEvent(options: AntiCheatCommonRegisterEventOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_RegisterEvent", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun logEvent(options: AntiCheatCommonLogEventOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_LogEvent", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun logGameRoundStart(options: AntiCheatCommonLogGameRoundStartOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_LogGameRoundStart", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun logGameRoundEnd(options: AntiCheatCommonLogGameRoundEndOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_LogGameRoundEnd", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun logPlayerSpawn(options: AntiCheatCommonLogPlayerSpawnOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_LogPlayerSpawn", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun logPlayerDespawn(options: AntiCheatCommonLogPlayerDespawnOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_LogPlayerDespawn", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun logPlayerRevive(options: AntiCheatCommonLogPlayerReviveOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_LogPlayerRevive", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun logPlayerTick(options: AntiCheatCommonLogPlayerTickOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_LogPlayerTick", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun logPlayerUseWeapon(options: AntiCheatCommonLogPlayerUseWeaponOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_LogPlayerUseWeapon", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun logPlayerUseAbility(options: AntiCheatCommonLogPlayerUseAbilityOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_LogPlayerUseAbility", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun logPlayerTakeDamage(options: AntiCheatCommonLogPlayerTakeDamageOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_AntiCheatServer_LogPlayerTakeDamage", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public companion object {
    public val NULL: HAntiCheatServer = HAntiCheatServer(0)
  }
}

@JvmInline
public value class HAuth(
  public val handle: Long,
) {
  public fun login(options: AuthLoginOptions, completionDelegate: (AuthLoginCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AuthLoginCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Auth_Login", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun logout(options: AuthLogoutOptions, completionDelegate: (AuthLogoutCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AuthLogoutCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Auth_Logout", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun linkAccount(options: AuthLinkAccountOptions, completionDelegate: (AuthLinkAccountCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AuthLinkAccountCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Auth_LinkAccount", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun deletePersistentAuth(options: AuthDeletePersistentAuthOptions, completionDelegate: (AuthDeletePersistentAuthCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AuthDeletePersistentAuthCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Auth_DeletePersistentAuth", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun verifyUserAuth(options: AuthVerifyUserAuthOptions, completionDelegate: (AuthVerifyUserAuthCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AuthVerifyUserAuthCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Auth_VerifyUserAuth", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getLoggedInAccountsCount(): Int = (Native.invoke("EOS_Auth_GetLoggedInAccountsCount", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getLoggedInAccountByIndex(index: Int): EpicAccountId = EpicAccountId(Native.invoke("EOS_Auth_GetLoggedInAccountByIndex", listOf(handle, index), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT), ValueLayout.JAVA_LONG) as Long)

  public fun getLoginStatus(localUserId: EpicAccountId): ELoginStatus = ELoginStatus(Native.invoke("EOS_Auth_GetLoginStatus", listOf(handle, localUserId.raw), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyUserAuthToken(options: AuthCopyUserAuthTokenOptions, localUserId: EpicAccountId): AuthToken = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Auth_CopyUserAuthToken", listOf(handle, options.address, localUserId.raw, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    AuthToken(RawMemory.getLong(out))
  }

  public fun copyIdToken(options: AuthCopyIdTokenOptions): AuthIdToken = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Auth_CopyIdToken", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    AuthIdToken(RawMemory.getLong(out))
  }

  public fun queryIdToken(options: AuthQueryIdTokenOptions, completionDelegate: (AuthQueryIdTokenCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AuthQueryIdTokenCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Auth_QueryIdToken", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun verifyIdToken(options: AuthVerifyIdTokenOptions, completionDelegate: (AuthVerifyIdTokenCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AuthVerifyIdTokenCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Auth_VerifyIdToken", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getSelectedAccountId(localUserId: EpicAccountId): EpicAccountId = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Auth_GetSelectedAccountId", listOf(handle, localUserId.raw, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    EpicAccountId(RawMemory.getLong(out))
  }

  public fun getMergedAccountsCount(localUserId: EpicAccountId): Int = (Native.invoke("EOS_Auth_GetMergedAccountsCount", listOf(handle, localUserId.raw), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getMergedAccountByIndex(localUserId: EpicAccountId, index: Int): EpicAccountId = EpicAccountId(Native.invoke("EOS_Auth_GetMergedAccountByIndex", listOf(handle, localUserId.raw, index), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT), ValueLayout.JAVA_LONG) as Long)

  public fun addNotifyLoginStatusChanged(options: AuthAddNotifyLoginStatusChangedOptions, notification: (AuthLoginStatusChangedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = AuthLoginStatusChangedCallbackInfo(data.address()); notification(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Auth_AddNotifyLoginStatusChanged", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyLoginStatusChanged(inId: Long) {
    Native.invokeVoid("EOS_Auth_RemoveNotifyLoginStatusChanged", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HAuth = HAuth(0)
  }
}

@JvmInline
public value class HConnect(
  public val handle: Long,
) {
  public fun login(options: ConnectLoginOptions, completionDelegate: (ConnectLoginCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ConnectLoginCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Connect_Login", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun logout(options: ConnectLogoutOptions, completionDelegate: (ConnectLogoutCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ConnectLogoutCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Connect_Logout", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun createUser(options: ConnectCreateUserOptions, completionDelegate: (ConnectCreateUserCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ConnectCreateUserCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Connect_CreateUser", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun linkAccount(options: ConnectLinkAccountOptions, completionDelegate: (ConnectLinkAccountCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ConnectLinkAccountCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Connect_LinkAccount", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun unlinkAccount(options: ConnectUnlinkAccountOptions, completionDelegate: (ConnectUnlinkAccountCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ConnectUnlinkAccountCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Connect_UnlinkAccount", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun createDeviceId(options: ConnectCreateDeviceIdOptions, completionDelegate: (ConnectCreateDeviceIdCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ConnectCreateDeviceIdCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Connect_CreateDeviceId", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun deleteDeviceId(options: ConnectDeleteDeviceIdOptions, completionDelegate: (ConnectDeleteDeviceIdCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ConnectDeleteDeviceIdCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Connect_DeleteDeviceId", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun transferDeviceIdAccount(options: ConnectTransferDeviceIdAccountOptions, completionDelegate: (ConnectTransferDeviceIdAccountCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ConnectTransferDeviceIdAccountCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Connect_TransferDeviceIdAccount", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryExternalAccountMappings(options: ConnectQueryExternalAccountMappingsOptions, completionDelegate: (ConnectQueryExternalAccountMappingsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ConnectQueryExternalAccountMappingsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Connect_QueryExternalAccountMappings", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryProductUserIdMappings(options: ConnectQueryProductUserIdMappingsOptions, completionDelegate: (ConnectQueryProductUserIdMappingsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ConnectQueryProductUserIdMappingsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Connect_QueryProductUserIdMappings", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getExternalAccountMapping(options: ConnectGetExternalAccountMappingsOptions): ProductUserId = ProductUserId(Native.invoke("EOS_Connect_GetExternalAccountMapping", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getProductUserIdMapping(options: ConnectGetProductUserIdMappingOptions): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_Connect_GetProductUserIdMapping", listOf(handle, options.address, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun getProductUserExternalAccountCount(options: ConnectGetProductUserExternalAccountCountOptions): Int = (Native.invoke("EOS_Connect_GetProductUserExternalAccountCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyProductUserExternalAccountByIndex(options: ConnectCopyProductUserExternalAccountByIndexOptions): ConnectExternalAccountInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Connect_CopyProductUserExternalAccountByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    ConnectExternalAccountInfo(RawMemory.getLong(out))
  }

  public fun copyProductUserExternalAccountByAccountType(options: ConnectCopyProductUserExternalAccountByAccountTypeOptions): ConnectExternalAccountInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Connect_CopyProductUserExternalAccountByAccountType", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    ConnectExternalAccountInfo(RawMemory.getLong(out))
  }

  public fun copyProductUserExternalAccountByAccountId(options: ConnectCopyProductUserExternalAccountByAccountIdOptions): ConnectExternalAccountInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Connect_CopyProductUserExternalAccountByAccountId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    ConnectExternalAccountInfo(RawMemory.getLong(out))
  }

  public fun copyProductUserInfo(options: ConnectCopyProductUserInfoOptions): ConnectExternalAccountInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Connect_CopyProductUserInfo", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    ConnectExternalAccountInfo(RawMemory.getLong(out))
  }

  public fun getLoggedInUsersCount(): Int = (Native.invoke("EOS_Connect_GetLoggedInUsersCount", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getLoggedInUserByIndex(index: Int): ProductUserId = ProductUserId(Native.invoke("EOS_Connect_GetLoggedInUserByIndex", listOf(handle, index), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT), ValueLayout.JAVA_LONG) as Long)

  public fun getLoginStatus(localUserId: ProductUserId): ELoginStatus = ELoginStatus(Native.invoke("EOS_Connect_GetLoginStatus", listOf(handle, localUserId.raw), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun addNotifyAuthExpiration(options: ConnectAddNotifyAuthExpirationOptions, notification: (ConnectAuthExpirationCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ConnectAuthExpirationCallbackInfo(data.address()); notification(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Connect_AddNotifyAuthExpiration", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyAuthExpiration(inId: Long) {
    Native.invokeVoid("EOS_Connect_RemoveNotifyAuthExpiration", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyLoginStatusChanged(options: ConnectAddNotifyLoginStatusChangedOptions, notification: (ConnectLoginStatusChangedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ConnectLoginStatusChangedCallbackInfo(data.address()); notification(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Connect_AddNotifyLoginStatusChanged", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyLoginStatusChanged(inId: Long) {
    Native.invokeVoid("EOS_Connect_RemoveNotifyLoginStatusChanged", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun copyIdToken(options: ConnectCopyIdTokenOptions): ConnectIdToken = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Connect_CopyIdToken", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    ConnectIdToken(RawMemory.getLong(out))
  }

  public fun verifyIdToken(options: ConnectVerifyIdTokenOptions, completionDelegate: (ConnectVerifyIdTokenCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ConnectVerifyIdTokenCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Connect_VerifyIdToken", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public companion object {
    public val NULL: HConnect = HConnect(0)
  }
}

@JvmInline
public value class HCustomInvites(
  public val handle: Long,
) {
  public fun setCustomInvite(options: CustomInvitesSetCustomInviteOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_CustomInvites_SetCustomInvite", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun sendCustomInvite(options: CustomInvitesSendCustomInviteOptions, completionDelegate: (CustomInvitesSendCustomInviteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = CustomInvitesSendCustomInviteCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_CustomInvites_SendCustomInvite", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun addNotifyCustomInviteReceived(options: CustomInvitesAddNotifyCustomInviteReceivedOptions, notificationFn: (CustomInvitesOnCustomInviteReceivedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = CustomInvitesOnCustomInviteReceivedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_CustomInvites_AddNotifyCustomInviteReceived", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyCustomInviteReceived(inId: Long) {
    Native.invokeVoid("EOS_CustomInvites_RemoveNotifyCustomInviteReceived", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyCustomInviteAccepted(options: CustomInvitesAddNotifyCustomInviteAcceptedOptions, notificationFn: (CustomInvitesOnCustomInviteAcceptedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = CustomInvitesOnCustomInviteAcceptedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_CustomInvites_AddNotifyCustomInviteAccepted", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyCustomInviteAccepted(inId: Long) {
    Native.invokeVoid("EOS_CustomInvites_RemoveNotifyCustomInviteAccepted", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyCustomInviteRejected(options: CustomInvitesAddNotifyCustomInviteRejectedOptions, notificationFn: (CustomInvitesCustomInviteRejectedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = CustomInvitesCustomInviteRejectedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_CustomInvites_AddNotifyCustomInviteRejected", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyCustomInviteRejected(inId: Long) {
    Native.invokeVoid("EOS_CustomInvites_RemoveNotifyCustomInviteRejected", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun finalizeInvite(options: CustomInvitesFinalizeInviteOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_CustomInvites_FinalizeInvite", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun sendRequestToJoin(options: CustomInvitesSendRequestToJoinOptions, completionDelegate: (CustomInvitesSendRequestToJoinCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = CustomInvitesSendRequestToJoinCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_CustomInvites_SendRequestToJoin", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun addNotifyRequestToJoinResponseReceived(options: CustomInvitesAddNotifyRequestToJoinResponseReceivedOptions, notificationFn: (CustomInvitesRequestToJoinResponseReceivedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = CustomInvitesRequestToJoinResponseReceivedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_CustomInvites_AddNotifyRequestToJoinResponseReceived", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyRequestToJoinResponseReceived(inId: Long) {
    Native.invokeVoid("EOS_CustomInvites_RemoveNotifyRequestToJoinResponseReceived", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyRequestToJoinReceived(options: CustomInvitesAddNotifyRequestToJoinReceivedOptions, notificationFn: (CustomInvitesRequestToJoinReceivedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = CustomInvitesRequestToJoinReceivedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_CustomInvites_AddNotifyRequestToJoinReceived", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyRequestToJoinReceived(inId: Long) {
    Native.invokeVoid("EOS_CustomInvites_RemoveNotifyRequestToJoinReceived", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifySendCustomNativeInviteRequested(options: CustomInvitesAddNotifySendCustomNativeInviteRequestedOptions, notificationFn: (CustomInvitesSendCustomNativeInviteRequestedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = CustomInvitesSendCustomNativeInviteRequestedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_CustomInvites_AddNotifySendCustomNativeInviteRequested", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifySendCustomNativeInviteRequested(inId: Long) {
    Native.invokeVoid("EOS_CustomInvites_RemoveNotifySendCustomNativeInviteRequested", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyRequestToJoinAccepted(options: CustomInvitesAddNotifyRequestToJoinAcceptedOptions, notificationFn: (CustomInvitesOnRequestToJoinAcceptedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = CustomInvitesOnRequestToJoinAcceptedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_CustomInvites_AddNotifyRequestToJoinAccepted", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyRequestToJoinAccepted(inId: Long) {
    Native.invokeVoid("EOS_CustomInvites_RemoveNotifyRequestToJoinAccepted", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyRequestToJoinRejected(options: CustomInvitesAddNotifyRequestToJoinRejectedOptions, notificationFn: (CustomInvitesOnRequestToJoinRejectedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = CustomInvitesOnRequestToJoinRejectedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_CustomInvites_AddNotifyRequestToJoinRejected", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyRequestToJoinRejected(inId: Long) {
    Native.invokeVoid("EOS_CustomInvites_RemoveNotifyRequestToJoinRejected", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun acceptRequestToJoin(options: CustomInvitesAcceptRequestToJoinOptions, completionDelegate: (CustomInvitesAcceptRequestToJoinCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = CustomInvitesAcceptRequestToJoinCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_CustomInvites_AcceptRequestToJoin", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun rejectRequestToJoin(options: CustomInvitesRejectRequestToJoinOptions, completionDelegate: (CustomInvitesRejectRequestToJoinCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = CustomInvitesRejectRequestToJoinCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_CustomInvites_RejectRequestToJoin", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun disableRequestToJoin(options: CustomInvitesDisableRequestToJoinOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_CustomInvites_DisableRequestToJoin", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public companion object {
    public val NULL: HCustomInvites = HCustomInvites(0)
  }
}

@JvmInline
public value class HEcom(
  public val handle: Long,
) {
  public fun queryOwnership(options: EcomQueryOwnershipOptions, completionDelegate: (EcomQueryOwnershipCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = EcomQueryOwnershipCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Ecom_QueryOwnership", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryOwnershipBySandboxIds(options: EcomQueryOwnershipBySandboxIdsOptions, completionDelegate: (EcomQueryOwnershipBySandboxIdsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = EcomQueryOwnershipBySandboxIdsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Ecom_QueryOwnershipBySandboxIds", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryOwnershipToken(options: EcomQueryOwnershipTokenOptions, completionDelegate: (EcomQueryOwnershipTokenCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = EcomQueryOwnershipTokenCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Ecom_QueryOwnershipToken", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryEntitlements(options: EcomQueryEntitlementsOptions, completionDelegate: (EcomQueryEntitlementsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = EcomQueryEntitlementsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Ecom_QueryEntitlements", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryEntitlementToken(options: EcomQueryEntitlementTokenOptions, completionDelegate: (EcomQueryEntitlementTokenCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = EcomQueryEntitlementTokenCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Ecom_QueryEntitlementToken", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryOffers(options: EcomQueryOffersOptions, completionDelegate: (EcomQueryOffersCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = EcomQueryOffersCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Ecom_QueryOffers", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun checkout(options: EcomCheckoutOptions, completionDelegate: (EcomCheckoutCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = EcomCheckoutCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Ecom_Checkout", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun redeemEntitlements(options: EcomRedeemEntitlementsOptions, completionDelegate: (EcomRedeemEntitlementsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = EcomRedeemEntitlementsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Ecom_RedeemEntitlements", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getLastRedeemedEntitlementsCount(options: EcomGetLastRedeemedEntitlementsCountOptions): Int = (Native.invoke("EOS_Ecom_GetLastRedeemedEntitlementsCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyLastRedeemedEntitlementByIndex(options: EcomCopyLastRedeemedEntitlementByIndexOptions, inOutRedeemedEntitlementIdLength: Long): Byte = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyLastRedeemedEntitlementByIndex", listOf(handle, options.address, out, inOutRedeemedEntitlementIdLength), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RawMemory.getByte(out)
  }

  public fun getLastRedeemEntitlementsResultCount(options: EcomGetLastRedeemEntitlementsResultCountOptions): Int = (Native.invoke("EOS_Ecom_GetLastRedeemEntitlementsResultCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyLastRedeemEntitlementsResultByIndex(options: EcomCopyLastRedeemEntitlementsResultByIndexOptions, inOutEntitlementIdLength: Long): Byte = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyLastRedeemEntitlementsResultByIndex", listOf(handle, options.address, out, inOutEntitlementIdLength), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RawMemory.getByte(out)
  }

  public fun getEntitlementsCount(options: EcomGetEntitlementsCountOptions): Int = (Native.invoke("EOS_Ecom_GetEntitlementsCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getEntitlementsByNameCount(options: EcomGetEntitlementsByNameCountOptions): Int = (Native.invoke("EOS_Ecom_GetEntitlementsByNameCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyEntitlementByIndex(options: EcomCopyEntitlementByIndexOptions): EcomEntitlement = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyEntitlementByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    EcomEntitlement(RawMemory.getLong(out))
  }

  public fun copyEntitlementByNameAndIndex(options: EcomCopyEntitlementByNameAndIndexOptions): EcomEntitlement = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyEntitlementByNameAndIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    EcomEntitlement(RawMemory.getLong(out))
  }

  public fun copyEntitlementById(options: EcomCopyEntitlementByIdOptions): EcomEntitlement = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyEntitlementById", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    EcomEntitlement(RawMemory.getLong(out))
  }

  public fun getOfferCount(options: EcomGetOfferCountOptions): Int = (Native.invoke("EOS_Ecom_GetOfferCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyOfferByIndex(options: EcomCopyOfferByIndexOptions): EcomCatalogOffer = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyOfferByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    EcomCatalogOffer(RawMemory.getLong(out))
  }

  public fun copyOfferById(options: EcomCopyOfferByIdOptions): EcomCatalogOffer = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyOfferById", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    EcomCatalogOffer(RawMemory.getLong(out))
  }

  public fun getOfferItemCount(options: EcomGetOfferItemCountOptions): Int = (Native.invoke("EOS_Ecom_GetOfferItemCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyOfferItemByIndex(options: EcomCopyOfferItemByIndexOptions): EcomCatalogItem = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyOfferItemByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    EcomCatalogItem(RawMemory.getLong(out))
  }

  public fun copyItemById(options: EcomCopyItemByIdOptions): EcomCatalogItem = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyItemById", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    EcomCatalogItem(RawMemory.getLong(out))
  }

  public fun getOfferImageInfoCount(options: EcomGetOfferImageInfoCountOptions): Int = (Native.invoke("EOS_Ecom_GetOfferImageInfoCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyOfferImageInfoByIndex(options: EcomCopyOfferImageInfoByIndexOptions): EcomKeyImageInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyOfferImageInfoByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    EcomKeyImageInfo(RawMemory.getLong(out))
  }

  public fun getItemImageInfoCount(options: EcomGetItemImageInfoCountOptions): Int = (Native.invoke("EOS_Ecom_GetItemImageInfoCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyItemImageInfoByIndex(options: EcomCopyItemImageInfoByIndexOptions): EcomKeyImageInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyItemImageInfoByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    EcomKeyImageInfo(RawMemory.getLong(out))
  }

  public fun getItemReleaseCount(options: EcomGetItemReleaseCountOptions): Int = (Native.invoke("EOS_Ecom_GetItemReleaseCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyItemReleaseByIndex(options: EcomCopyItemReleaseByIndexOptions): EcomCatalogRelease = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyItemReleaseByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    EcomCatalogRelease(RawMemory.getLong(out))
  }

  public fun getTransactionCount(options: EcomGetTransactionCountOptions): Int = (Native.invoke("EOS_Ecom_GetTransactionCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyTransactionByIndex(options: EcomCopyTransactionByIndexOptions): Long = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyTransactionByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RawMemory.getLong(out)
  }

  public fun copyTransactionById(options: EcomCopyTransactionByIdOptions): Long = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_CopyTransactionById", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RawMemory.getLong(out)
  }

  public companion object {
    public val NULL: HEcom = HEcom(0)
  }
}

@JvmInline
public value class HFriends(
  public val handle: Long,
) {
  public fun queryFriends(options: FriendsQueryFriendsOptions, completionDelegate: (FriendsQueryFriendsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = FriendsQueryFriendsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Friends_QueryFriends", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun sendInvite(options: FriendsSendInviteOptions, completionDelegate: (FriendsSendInviteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = FriendsSendInviteCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Friends_SendInvite", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun acceptInvite(options: FriendsAcceptInviteOptions, completionDelegate: (FriendsAcceptInviteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = FriendsAcceptInviteCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Friends_AcceptInvite", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun rejectInvite(options: FriendsRejectInviteOptions, completionDelegate: (FriendsRejectInviteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = FriendsRejectInviteCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Friends_RejectInvite", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getFriendsCount(options: FriendsGetFriendsCountOptions): Int = (Native.invoke("EOS_Friends_GetFriendsCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getFriendAtIndex(options: FriendsGetFriendAtIndexOptions): EpicAccountId = EpicAccountId(Native.invoke("EOS_Friends_GetFriendAtIndex", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getStatus(options: FriendsGetStatusOptions): EFriendsStatus = EFriendsStatus(Native.invoke("EOS_Friends_GetStatus", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun addNotifyFriendsUpdate(options: FriendsAddNotifyFriendsUpdateOptions, friendsUpdateHandler: (FriendsOnFriendsUpdateInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = FriendsOnFriendsUpdateInfo(data.address()); friendsUpdateHandler(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Friends_AddNotifyFriendsUpdate", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyFriendsUpdate(notificationId: Long) {
    Native.invokeVoid("EOS_Friends_RemoveNotifyFriendsUpdate", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun getBlockedUsersCount(options: FriendsGetBlockedUsersCountOptions): Int = (Native.invoke("EOS_Friends_GetBlockedUsersCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getBlockedUserAtIndex(options: FriendsGetBlockedUserAtIndexOptions): EpicAccountId = EpicAccountId(Native.invoke("EOS_Friends_GetBlockedUserAtIndex", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun addNotifyBlockedUsersUpdate(options: FriendsAddNotifyBlockedUsersUpdateOptions, blockedUsersUpdateHandler: (FriendsOnBlockedUsersUpdateInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = FriendsOnBlockedUsersUpdateInfo(data.address()); blockedUsersUpdateHandler(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Friends_AddNotifyBlockedUsersUpdate", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyBlockedUsersUpdate(notificationId: Long) {
    Native.invokeVoid("EOS_Friends_RemoveNotifyBlockedUsersUpdate", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HFriends = HFriends(0)
  }
}

@JvmInline
public value class HIntegratedPlatform(
  public val handle: Long,
) {
  public fun setUserLoginStatus(options: IntegratedPlatformSetUserLoginStatusOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_IntegratedPlatform_SetUserLoginStatus", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun addNotifyUserLoginStatusChanged(options: IntegratedPlatformAddNotifyUserLoginStatusChangedOptions, callbackFunction: (IntegratedPlatformUserLoginStatusChangedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = IntegratedPlatformUserLoginStatusChangedCallbackInfo(data.address()); callbackFunction(info) }
    stubId = stub.id
    return (Native.invoke("EOS_IntegratedPlatform_AddNotifyUserLoginStatusChanged", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyUserLoginStatusChanged(notificationId: Long) {
    Native.invokeVoid("EOS_IntegratedPlatform_RemoveNotifyUserLoginStatusChanged", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun setUserPreLogoutCallback(options: IntegratedPlatformSetUserPreLogoutCallbackOptions, callbackFunction: Long): EosResult = EosResult.fromValue(Native.invoke("EOS_IntegratedPlatform_SetUserPreLogoutCallback", listOf(handle, options.address, 0L, callbackFunction), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun clearUserPreLogoutCallback(options: IntegratedPlatformClearUserPreLogoutCallbackOptions) {
    Native.invokeVoid("EOS_IntegratedPlatform_ClearUserPreLogoutCallback", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun finalizeDeferredUserLogout(options: IntegratedPlatformFinalizeDeferredUserLogoutOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_IntegratedPlatform_FinalizeDeferredUserLogout", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public companion object {
    public val NULL: HIntegratedPlatform = HIntegratedPlatform(0)
  }
}

@JvmInline
public value class HIntegratedPlatformOptionsContainer(
  public val handle: Long,
) {
  public fun add(inOptions: IntegratedPlatformOptionsContainerAddOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_IntegratedPlatformOptionsContainer_Add", listOf(handle, inOptions.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun release() {
    Native.invokeVoid("EOS_IntegratedPlatformOptionsContainer_Release", listOf(handle), listOf(ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HIntegratedPlatformOptionsContainer = HIntegratedPlatformOptionsContainer(0)
  }
}

@JvmInline
public value class HKWS(
  public val handle: Long,
) {
  public fun queryAgeGate(options: KWSQueryAgeGateOptions, completionDelegate: (KWSQueryAgeGateCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = KWSQueryAgeGateCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_KWS_QueryAgeGate", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun createUser(options: KWSCreateUserOptions, completionDelegate: (KWSCreateUserCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = KWSCreateUserCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_KWS_CreateUser", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryPermissions(options: KWSQueryPermissionsOptions, completionDelegate: (KWSQueryPermissionsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = KWSQueryPermissionsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_KWS_QueryPermissions", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun updateParentEmail(options: KWSUpdateParentEmailOptions, completionDelegate: (KWSUpdateParentEmailCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = KWSUpdateParentEmailCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_KWS_UpdateParentEmail", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun requestPermissions(options: KWSRequestPermissionsOptions, completionDelegate: (KWSRequestPermissionsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = KWSRequestPermissionsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_KWS_RequestPermissions", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getPermissionsCount(options: KWSGetPermissionsCountOptions): Int = (Native.invoke("EOS_KWS_GetPermissionsCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyPermissionByIndex(options: KWSCopyPermissionByIndexOptions): KWSPermissionStatus = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_KWS_CopyPermissionByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    KWSPermissionStatus(RawMemory.getLong(out))
  }

  public fun getPermissionByKey(options: KWSGetPermissionByKeyOptions): EKWSPermissionStatus = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_KWS_GetPermissionByKey", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    EKWSPermissionStatus(RawMemory.getInt(out))
  }

  public fun addNotifyPermissionsUpdateReceived(options: KWSAddNotifyPermissionsUpdateReceivedOptions, notificationFn: (KWSPermissionsUpdateReceivedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = KWSPermissionsUpdateReceivedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_KWS_AddNotifyPermissionsUpdateReceived", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyPermissionsUpdateReceived(inId: Long) {
    Native.invokeVoid("EOS_KWS_RemoveNotifyPermissionsUpdateReceived", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HKWS = HKWS(0)
  }
}

@JvmInline
public value class HLeaderboards(
  public val handle: Long,
) {
  public fun queryLeaderboardDefinitions(options: LeaderboardsQueryLeaderboardDefinitionsOptions, completionDelegate: (LeaderboardsOnQueryLeaderboardDefinitionsCompleteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LeaderboardsOnQueryLeaderboardDefinitionsCompleteCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_Leaderboards_QueryLeaderboardDefinitions", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getLeaderboardDefinitionCount(options: LeaderboardsGetLeaderboardDefinitionCountOptions): Int = (Native.invoke("EOS_Leaderboards_GetLeaderboardDefinitionCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyLeaderboardDefinitionByIndex(options: LeaderboardsCopyLeaderboardDefinitionByIndexOptions): LeaderboardsDefinition = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Leaderboards_CopyLeaderboardDefinitionByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    LeaderboardsDefinition(RawMemory.getLong(out))
  }

  public fun copyLeaderboardDefinitionByLeaderboardId(options: LeaderboardsCopyLeaderboardDefinitionByLeaderboardIdOptions): LeaderboardsDefinition = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    LeaderboardsDefinition(RawMemory.getLong(out))
  }

  public fun queryLeaderboardRanks(options: LeaderboardsQueryLeaderboardRanksOptions, completionDelegate: (LeaderboardsOnQueryLeaderboardRanksCompleteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LeaderboardsOnQueryLeaderboardRanksCompleteCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_Leaderboards_QueryLeaderboardRanks", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getLeaderboardRecordCount(options: LeaderboardsGetLeaderboardRecordCountOptions): Int = (Native.invoke("EOS_Leaderboards_GetLeaderboardRecordCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyLeaderboardRecordByIndex(options: LeaderboardsCopyLeaderboardRecordByIndexOptions): LeaderboardsLeaderboardRecord = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Leaderboards_CopyLeaderboardRecordByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    LeaderboardsLeaderboardRecord(RawMemory.getLong(out))
  }

  public fun copyLeaderboardRecordByUserId(options: LeaderboardsCopyLeaderboardRecordByUserIdOptions): LeaderboardsLeaderboardRecord = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Leaderboards_CopyLeaderboardRecordByUserId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    LeaderboardsLeaderboardRecord(RawMemory.getLong(out))
  }

  public fun queryLeaderboardUserScores(options: LeaderboardsQueryLeaderboardUserScoresOptions, completionDelegate: (LeaderboardsOnQueryLeaderboardUserScoresCompleteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LeaderboardsOnQueryLeaderboardUserScoresCompleteCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_Leaderboards_QueryLeaderboardUserScores", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getLeaderboardUserScoreCount(options: LeaderboardsGetLeaderboardUserScoreCountOptions): Int = (Native.invoke("EOS_Leaderboards_GetLeaderboardUserScoreCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyLeaderboardUserScoreByIndex(options: LeaderboardsCopyLeaderboardUserScoreByIndexOptions): LeaderboardsLeaderboardUserScore = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Leaderboards_CopyLeaderboardUserScoreByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    LeaderboardsLeaderboardUserScore(RawMemory.getLong(out))
  }

  public fun copyLeaderboardUserScoreByUserId(options: LeaderboardsCopyLeaderboardUserScoreByUserIdOptions): LeaderboardsLeaderboardUserScore = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Leaderboards_CopyLeaderboardUserScoreByUserId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    LeaderboardsLeaderboardUserScore(RawMemory.getLong(out))
  }

  public companion object {
    public val NULL: HLeaderboards = HLeaderboards(0)
  }
}

@JvmInline
public value class HLobby(
  public val handle: Long,
) {
  public fun createLobby(options: LobbyCreateLobbyOptions, completionDelegate: (LobbyCreateLobbyCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyCreateLobbyCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_CreateLobby", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun destroyLobby(options: LobbyDestroyLobbyOptions, completionDelegate: (LobbyDestroyLobbyCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyDestroyLobbyCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_DestroyLobby", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun joinLobby(options: LobbyJoinLobbyOptions, completionDelegate: (LobbyJoinLobbyCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyJoinLobbyCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_JoinLobby", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun joinLobbyById(options: LobbyJoinLobbyByIdOptions, completionDelegate: (LobbyJoinLobbyByIdCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyJoinLobbyByIdCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_JoinLobbyById", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun leaveLobby(options: LobbyLeaveLobbyOptions, completionDelegate: (LobbyLeaveLobbyCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyLeaveLobbyCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_LeaveLobby", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun updateLobbyModification(options: LobbyUpdateLobbyModificationOptions): HLobbyModification = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Lobby_UpdateLobbyModification", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HLobbyModification(RawMemory.getLong(out))
  }

  public fun updateLobby(options: LobbyUpdateLobbyOptions, completionDelegate: (LobbyUpdateLobbyCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyUpdateLobbyCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_UpdateLobby", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun promoteMember(options: LobbyPromoteMemberOptions, completionDelegate: (LobbyPromoteMemberCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyPromoteMemberCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_PromoteMember", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun kickMember(options: LobbyKickMemberOptions, completionDelegate: (LobbyKickMemberCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyKickMemberCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_KickMember", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun hardMuteMember(options: LobbyHardMuteMemberOptions, completionDelegate: (LobbyHardMuteMemberCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyHardMuteMemberCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_HardMuteMember", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun addNotifyLobbyUpdateReceived(options: LobbyAddNotifyLobbyUpdateReceivedOptions, notificationFn: (LobbyLobbyUpdateReceivedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyLobbyUpdateReceivedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Lobby_AddNotifyLobbyUpdateReceived", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyLobbyUpdateReceived(inId: Long) {
    Native.invokeVoid("EOS_Lobby_RemoveNotifyLobbyUpdateReceived", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyLobbyMemberUpdateReceived(options: LobbyAddNotifyLobbyMemberUpdateReceivedOptions, notificationFn: (LobbyLobbyMemberUpdateReceivedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyLobbyMemberUpdateReceivedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Lobby_AddNotifyLobbyMemberUpdateReceived", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyLobbyMemberUpdateReceived(inId: Long) {
    Native.invokeVoid("EOS_Lobby_RemoveNotifyLobbyMemberUpdateReceived", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyLobbyMemberStatusReceived(options: LobbyAddNotifyLobbyMemberStatusReceivedOptions, notificationFn: (LobbyLobbyMemberStatusReceivedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyLobbyMemberStatusReceivedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Lobby_AddNotifyLobbyMemberStatusReceived", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyLobbyMemberStatusReceived(inId: Long) {
    Native.invokeVoid("EOS_Lobby_RemoveNotifyLobbyMemberStatusReceived", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun sendInvite(options: LobbySendInviteOptions, completionDelegate: (LobbySendInviteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbySendInviteCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_SendInvite", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun rejectInvite(options: LobbyRejectInviteOptions, completionDelegate: (LobbyRejectInviteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyRejectInviteCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_RejectInvite", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryInvites(options: LobbyQueryInvitesOptions, completionDelegate: (LobbyQueryInvitesCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyQueryInvitesCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_QueryInvites", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getInviteCount(options: LobbyGetInviteCountOptions): Int = (Native.invoke("EOS_Lobby_GetInviteCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getInviteIdByIndex(options: LobbyGetInviteIdByIndexOptions): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_Lobby_GetInviteIdByIndex", listOf(handle, options.address, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun createLobbySearch(options: LobbyCreateLobbySearchOptions): HLobbySearch = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Lobby_CreateLobbySearch", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HLobbySearch(RawMemory.getLong(out))
  }

  public fun addNotifyLobbyInviteReceived(options: LobbyAddNotifyLobbyInviteReceivedOptions, notificationFn: (LobbyLobbyInviteReceivedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyLobbyInviteReceivedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Lobby_AddNotifyLobbyInviteReceived", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyLobbyInviteReceived(inId: Long) {
    Native.invokeVoid("EOS_Lobby_RemoveNotifyLobbyInviteReceived", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyLobbyInviteAccepted(options: LobbyAddNotifyLobbyInviteAcceptedOptions, notificationFn: (LobbyLobbyInviteAcceptedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyLobbyInviteAcceptedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Lobby_AddNotifyLobbyInviteAccepted", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyLobbyInviteAccepted(inId: Long) {
    Native.invokeVoid("EOS_Lobby_RemoveNotifyLobbyInviteAccepted", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyLobbyInviteRejected(options: LobbyAddNotifyLobbyInviteRejectedOptions, notificationFn: (LobbyLobbyInviteRejectedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyLobbyInviteRejectedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Lobby_AddNotifyLobbyInviteRejected", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyLobbyInviteRejected(inId: Long) {
    Native.invokeVoid("EOS_Lobby_RemoveNotifyLobbyInviteRejected", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyJoinLobbyAccepted(options: LobbyAddNotifyJoinLobbyAcceptedOptions, notificationFn: (LobbyJoinLobbyAcceptedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyJoinLobbyAcceptedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Lobby_AddNotifyJoinLobbyAccepted", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyJoinLobbyAccepted(inId: Long) {
    Native.invokeVoid("EOS_Lobby_RemoveNotifyJoinLobbyAccepted", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifySendLobbyNativeInviteRequested(options: LobbyAddNotifySendLobbyNativeInviteRequestedOptions, notificationFn: (LobbySendLobbyNativeInviteRequestedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbySendLobbyNativeInviteRequestedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Lobby_AddNotifySendLobbyNativeInviteRequested", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifySendLobbyNativeInviteRequested(inId: Long) {
    Native.invokeVoid("EOS_Lobby_RemoveNotifySendLobbyNativeInviteRequested", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun copyLobbyDetailsHandleByInviteId(options: LobbyCopyLobbyDetailsHandleByInviteIdOptions): HLobbyDetails = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Lobby_CopyLobbyDetailsHandleByInviteId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HLobbyDetails(RawMemory.getLong(out))
  }

  public fun copyLobbyDetailsHandleByUiEventId(options: LobbyCopyLobbyDetailsHandleByUiEventIdOptions): HLobbyDetails = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Lobby_CopyLobbyDetailsHandleByUiEventId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HLobbyDetails(RawMemory.getLong(out))
  }

  public fun copyLobbyDetailsHandle(options: LobbyCopyLobbyDetailsHandleOptions): HLobbyDetails = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Lobby_CopyLobbyDetailsHandle", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HLobbyDetails(RawMemory.getLong(out))
  }

  public fun getRTCRoomName(options: LobbyGetRTCRoomNameOptions): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_Lobby_GetRTCRoomName", listOf(handle, options.address, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun joinRTCRoom(options: LobbyJoinRTCRoomOptions, completionDelegate: (LobbyJoinRTCRoomCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyJoinRTCRoomCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_JoinRTCRoom", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun leaveRTCRoom(options: LobbyLeaveRTCRoomOptions, completionDelegate: (LobbyLeaveRTCRoomCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyLeaveRTCRoomCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Lobby_LeaveRTCRoom", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun isRTCRoomConnected(options: LobbyIsRTCRoomConnectedOptions, outIsConnected: Long): EosResult = EosResult.fromValue(Native.invoke("EOS_Lobby_IsRTCRoomConnected", listOf(handle, options.address, outIsConnected), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun addNotifyRTCRoomConnectionChanged(options: LobbyAddNotifyRTCRoomConnectionChangedOptions, notificationFn: (LobbyRTCRoomConnectionChangedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyRTCRoomConnectionChangedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Lobby_AddNotifyRTCRoomConnectionChanged", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyRTCRoomConnectionChanged(inId: Long) {
    Native.invokeVoid("EOS_Lobby_RemoveNotifyRTCRoomConnectionChanged", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun getConnectString(options: LobbyGetConnectStringOptions): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_Lobby_GetConnectString", listOf(handle, options.address, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun parseConnectString(options: LobbyParseConnectStringOptions): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_Lobby_ParseConnectString", listOf(handle, options.address, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun addNotifyLeaveLobbyRequested(options: LobbyAddNotifyLeaveLobbyRequestedOptions, notificationFn: (LobbyLeaveLobbyRequestedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbyLeaveLobbyRequestedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Lobby_AddNotifyLeaveLobbyRequested", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyLeaveLobbyRequested(inId: Long) {
    Native.invokeVoid("EOS_Lobby_RemoveNotifyLeaveLobbyRequested", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HLobby = HLobby(0)
  }
}

@JvmInline
public value class HLobbyDetails(
  public val handle: Long,
) {
  public fun getLobbyOwner(options: LobbyDetailsGetLobbyOwnerOptions): ProductUserId = ProductUserId(Native.invoke("EOS_LobbyDetails_GetLobbyOwner", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun copyInfo(options: LobbyDetailsCopyInfoOptions): LobbyDetailsInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_LobbyDetails_CopyInfo", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    LobbyDetailsInfo(RawMemory.getLong(out))
  }

  public fun copyMemberInfo(options: LobbyDetailsCopyMemberInfoOptions): LobbyDetailsMemberInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_LobbyDetails_CopyMemberInfo", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    LobbyDetailsMemberInfo(RawMemory.getLong(out))
  }

  public fun getAttributeCount(options: LobbyDetailsGetAttributeCountOptions): Int = (Native.invoke("EOS_LobbyDetails_GetAttributeCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyAttributeByIndex(options: LobbyDetailsCopyAttributeByIndexOptions): LobbyAttribute = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_LobbyDetails_CopyAttributeByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    LobbyAttribute(RawMemory.getLong(out))
  }

  public fun copyAttributeByKey(options: LobbyDetailsCopyAttributeByKeyOptions): LobbyAttribute = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_LobbyDetails_CopyAttributeByKey", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    LobbyAttribute(RawMemory.getLong(out))
  }

  public fun getMemberCount(options: LobbyDetailsGetMemberCountOptions): Int = (Native.invoke("EOS_LobbyDetails_GetMemberCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getMemberByIndex(options: LobbyDetailsGetMemberByIndexOptions): ProductUserId = ProductUserId(Native.invoke("EOS_LobbyDetails_GetMemberByIndex", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getMemberAttributeCount(options: LobbyDetailsGetMemberAttributeCountOptions): Int = (Native.invoke("EOS_LobbyDetails_GetMemberAttributeCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyMemberAttributeByIndex(options: LobbyDetailsCopyMemberAttributeByIndexOptions): LobbyAttribute = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_LobbyDetails_CopyMemberAttributeByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    LobbyAttribute(RawMemory.getLong(out))
  }

  public fun copyMemberAttributeByKey(options: LobbyDetailsCopyMemberAttributeByKeyOptions): LobbyAttribute = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_LobbyDetails_CopyMemberAttributeByKey", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    LobbyAttribute(RawMemory.getLong(out))
  }

  public fun release() {
    Native.invokeVoid("EOS_LobbyDetails_Release", listOf(handle), listOf(ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HLobbyDetails = HLobbyDetails(0)
  }
}

@JvmInline
public value class HLobbyModification(
  public val handle: Long,
) {
  public fun setBucketId(options: LobbyModificationSetBucketIdOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbyModification_SetBucketId", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setPermissionLevel(options: LobbyModificationSetPermissionLevelOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbyModification_SetPermissionLevel", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setMaxMembers(options: LobbyModificationSetMaxMembersOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbyModification_SetMaxMembers", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setInvitesAllowed(options: LobbyModificationSetInvitesAllowedOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbyModification_SetInvitesAllowed", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun addAttribute(options: LobbyModificationAddAttributeOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbyModification_AddAttribute", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun removeAttribute(options: LobbyModificationRemoveAttributeOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbyModification_RemoveAttribute", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun addMemberAttribute(options: LobbyModificationAddMemberAttributeOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbyModification_AddMemberAttribute", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun removeMemberAttribute(options: LobbyModificationRemoveMemberAttributeOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbyModification_RemoveMemberAttribute", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setAllowedPlatformIds(options: LobbyModificationSetAllowedPlatformIdsOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbyModification_SetAllowedPlatformIds", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun release() {
    Native.invokeVoid("EOS_LobbyModification_Release", listOf(handle), listOf(ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HLobbyModification = HLobbyModification(0)
  }
}

@JvmInline
public value class HLobbySearch(
  public val handle: Long,
) {
  public fun find(options: LobbySearchFindOptions, completionDelegate: (LobbySearchFindCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = LobbySearchFindCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_LobbySearch_Find", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun setLobbyId(options: LobbySearchSetLobbyIdOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbySearch_SetLobbyId", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setTargetUserId(options: LobbySearchSetTargetUserIdOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbySearch_SetTargetUserId", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setParameter(options: LobbySearchSetParameterOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbySearch_SetParameter", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun removeParameter(options: LobbySearchRemoveParameterOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbySearch_RemoveParameter", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setMaxResults(options: LobbySearchSetMaxResultsOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_LobbySearch_SetMaxResults", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getSearchResultCount(options: LobbySearchGetSearchResultCountOptions): Int = (Native.invoke("EOS_LobbySearch_GetSearchResultCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copySearchResultByIndex(options: LobbySearchCopySearchResultByIndexOptions): HLobbyDetails = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_LobbySearch_CopySearchResultByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HLobbyDetails(RawMemory.getLong(out))
  }

  public fun release() {
    Native.invokeVoid("EOS_LobbySearch_Release", listOf(handle), listOf(ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HLobbySearch = HLobbySearch(0)
  }
}

@JvmInline
public value class HMetrics(
  public val handle: Long,
) {
  public fun beginPlayerSession(options: MetricsBeginPlayerSessionOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_Metrics_BeginPlayerSession", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun endPlayerSession(options: MetricsEndPlayerSessionOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_Metrics_EndPlayerSession", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public companion object {
    public val NULL: HMetrics = HMetrics(0)
  }
}

@JvmInline
public value class HMods(
  public val handle: Long,
) {
  public fun installMod(options: ModsInstallModOptions, completionDelegate: (ModsInstallModCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ModsInstallModCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Mods_InstallMod", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun uninstallMod(options: ModsUninstallModOptions, completionDelegate: (ModsUninstallModCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ModsUninstallModCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Mods_UninstallMod", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun enumerateMods(options: ModsEnumerateModsOptions, completionDelegate: (ModsEnumerateModsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ModsEnumerateModsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Mods_EnumerateMods", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun copyModInfo(options: ModsCopyModInfoOptions): ModsModInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Mods_CopyModInfo", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    ModsModInfo(RawMemory.getLong(out))
  }

  public fun updateMod(options: ModsUpdateModOptions, completionDelegate: (ModsUpdateModCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ModsUpdateModCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Mods_UpdateMod", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public companion object {
    public val NULL: HMods = HMods(0)
  }
}

@JvmInline
public value class HP2P(
  public val handle: Long,
) {
  public fun sendPacket(options: P2PSendPacketOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_P2P_SendPacket", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getNextReceivedPacketSize(options: P2PGetNextReceivedPacketSizeOptions): Int = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_P2P_GetNextReceivedPacketSize", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RawMemory.getInt(out)
  }

  public fun receivePacket(
    options: P2PReceivePacketOptions,
    outPeerId: Long,
    outSocketId: P2PSocketId,
    outChannel: Long,
    outData: Long,
    outBytesWritten: Long,
  ): EosResult = EosResult.fromValue(Native.invoke("EOS_P2P_ReceivePacket", listOf(handle, options.address, outPeerId, outSocketId.address, outChannel, outData, outBytesWritten), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun addNotifyPeerConnectionRequest(options: P2PAddNotifyPeerConnectionRequestOptions, connectionRequestHandler: (P2POnIncomingConnectionRequestInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = P2POnIncomingConnectionRequestInfo(data.address()); connectionRequestHandler(info) }
    stubId = stub.id
    return (Native.invoke("EOS_P2P_AddNotifyPeerConnectionRequest", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyPeerConnectionRequest(notificationId: Long) {
    Native.invokeVoid("EOS_P2P_RemoveNotifyPeerConnectionRequest", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyPeerConnectionEstablished(options: P2PAddNotifyPeerConnectionEstablishedOptions, connectionEstablishedHandler: (P2POnPeerConnectionEstablishedInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = P2POnPeerConnectionEstablishedInfo(data.address()); connectionEstablishedHandler(info) }
    stubId = stub.id
    return (Native.invoke("EOS_P2P_AddNotifyPeerConnectionEstablished", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyPeerConnectionEstablished(notificationId: Long) {
    Native.invokeVoid("EOS_P2P_RemoveNotifyPeerConnectionEstablished", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyPeerConnectionInterrupted(options: P2PAddNotifyPeerConnectionInterruptedOptions, connectionInterruptedHandler: (P2POnPeerConnectionInterruptedInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = P2POnPeerConnectionInterruptedInfo(data.address()); connectionInterruptedHandler(info) }
    stubId = stub.id
    return (Native.invoke("EOS_P2P_AddNotifyPeerConnectionInterrupted", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyPeerConnectionInterrupted(notificationId: Long) {
    Native.invokeVoid("EOS_P2P_RemoveNotifyPeerConnectionInterrupted", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyPeerConnectionClosed(options: P2PAddNotifyPeerConnectionClosedOptions, connectionClosedHandler: (P2POnRemoteConnectionClosedInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = P2POnRemoteConnectionClosedInfo(data.address()); connectionClosedHandler(info) }
    stubId = stub.id
    return (Native.invoke("EOS_P2P_AddNotifyPeerConnectionClosed", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyPeerConnectionClosed(notificationId: Long) {
    Native.invokeVoid("EOS_P2P_RemoveNotifyPeerConnectionClosed", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun acceptConnection(options: P2PAcceptConnectionOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_P2P_AcceptConnection", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun closeConnection(options: P2PCloseConnectionOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_P2P_CloseConnection", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun closeConnections(options: P2PCloseConnectionsOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_P2P_CloseConnections", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun queryNATType(options: P2PQueryNATTypeOptions, completionDelegate: (P2POnQueryNATTypeCompleteInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = P2POnQueryNATTypeCompleteInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_P2P_QueryNATType", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getNATType(options: P2PGetNATTypeOptions): ENATType = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_P2P_GetNATType", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    ENATType(RawMemory.getInt(out))
  }

  public fun setRelayControl(options: P2PSetRelayControlOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_P2P_SetRelayControl", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getRelayControl(options: P2PGetRelayControlOptions): ERelayControl = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_P2P_GetRelayControl", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    ERelayControl(RawMemory.getInt(out))
  }

  public fun setPortRange(options: P2PSetPortRangeOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_P2P_SetPortRange", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getPortRange(
    options: P2PGetPortRangeOptions,
    outPort: Long,
    outNumAdditionalPortsToTry: Long,
  ): EosResult = EosResult.fromValue(Native.invoke("EOS_P2P_GetPortRange", listOf(handle, options.address, outPort, outNumAdditionalPortsToTry), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setPacketQueueSize(options: P2PSetPacketQueueSizeOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_P2P_SetPacketQueueSize", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getPacketQueueInfo(options: P2PGetPacketQueueInfoOptions, outPacketQueueInfo: P2PPacketQueueInfo): EosResult = EosResult.fromValue(Native.invoke("EOS_P2P_GetPacketQueueInfo", listOf(handle, options.address, outPacketQueueInfo.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun addNotifyIncomingPacketQueueFull(options: P2PAddNotifyIncomingPacketQueueFullOptions, incomingPacketQueueFullHandler: (P2POnIncomingPacketQueueFullInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = P2POnIncomingPacketQueueFullInfo(data.address()); incomingPacketQueueFullHandler(info) }
    stubId = stub.id
    return (Native.invoke("EOS_P2P_AddNotifyIncomingPacketQueueFull", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyIncomingPacketQueueFull(notificationId: Long) {
    Native.invokeVoid("EOS_P2P_RemoveNotifyIncomingPacketQueueFull", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun clearPacketQueue(options: P2PClearPacketQueueOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_P2P_ClearPacketQueue", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public companion object {
    public val NULL: HP2P = HP2P(0)
  }
}

@JvmInline
public value class HPlatform(
  public val handle: Long,
) {
  public fun release() {
    Native.invokeVoid("EOS_Platform_Release", listOf(handle), listOf(ValueLayout.JAVA_LONG))
  }

  public fun tick() {
    Native.invokeVoid("EOS_Platform_Tick", listOf(handle), listOf(ValueLayout.JAVA_LONG))
  }

  public fun getMetricsInterface(): HMetrics = HMetrics(Native.invoke("EOS_Platform_GetMetricsInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getAuthInterface(): HAuth = HAuth(Native.invoke("EOS_Platform_GetAuthInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getConnectInterface(): HConnect = HConnect(Native.invoke("EOS_Platform_GetConnectInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getEcomInterface(): HEcom = HEcom(Native.invoke("EOS_Platform_GetEcomInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getUIInterface(): HUI = HUI(Native.invoke("EOS_Platform_GetUIInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getFriendsInterface(): HFriends = HFriends(Native.invoke("EOS_Platform_GetFriendsInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getPresenceInterface(): HPresence = HPresence(Native.invoke("EOS_Platform_GetPresenceInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getSessionsInterface(): HSessions = HSessions(Native.invoke("EOS_Platform_GetSessionsInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getLobbyInterface(): HLobby = HLobby(Native.invoke("EOS_Platform_GetLobbyInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getUserInfoInterface(): HUserInfo = HUserInfo(Native.invoke("EOS_Platform_GetUserInfoInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getP2PInterface(): HP2P = HP2P(Native.invoke("EOS_Platform_GetP2PInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getRTCInterface(): HRTC = HRTC(Native.invoke("EOS_Platform_GetRTCInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getRTCAdminInterface(): HRTCAdmin = HRTCAdmin(Native.invoke("EOS_Platform_GetRTCAdminInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getPlayerDataStorageInterface(): HPlayerDataStorage = HPlayerDataStorage(Native.invoke("EOS_Platform_GetPlayerDataStorageInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getTitleStorageInterface(): HTitleStorage = HTitleStorage(Native.invoke("EOS_Platform_GetTitleStorageInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getAchievementsInterface(): HAchievements = HAchievements(Native.invoke("EOS_Platform_GetAchievementsInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getStatsInterface(): HStats = HStats(Native.invoke("EOS_Platform_GetStatsInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getLeaderboardsInterface(): HLeaderboards = HLeaderboards(Native.invoke("EOS_Platform_GetLeaderboardsInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getModsInterface(): HMods = HMods(Native.invoke("EOS_Platform_GetModsInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getAntiCheatClientInterface(): HAntiCheatClient = HAntiCheatClient(Native.invoke("EOS_Platform_GetAntiCheatClientInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getAntiCheatServerInterface(): HAntiCheatServer = HAntiCheatServer(Native.invoke("EOS_Platform_GetAntiCheatServerInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getProgressionSnapshotInterface(): HProgressionSnapshot = HProgressionSnapshot(Native.invoke("EOS_Platform_GetProgressionSnapshotInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getReportsInterface(): HReports = HReports(Native.invoke("EOS_Platform_GetReportsInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getSanctionsInterface(): HSanctions = HSanctions(Native.invoke("EOS_Platform_GetSanctionsInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getKWSInterface(): HKWS = HKWS(Native.invoke("EOS_Platform_GetKWSInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getCustomInvitesInterface(): HCustomInvites = HCustomInvites(Native.invoke("EOS_Platform_GetCustomInvitesInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getIntegratedPlatformInterface(): HIntegratedPlatform = HIntegratedPlatform(Native.invoke("EOS_Platform_GetIntegratedPlatformInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getActiveCountryCode(localUserId: EpicAccountId): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_Platform_GetActiveCountryCode", listOf(handle, localUserId.raw, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun getActiveLocaleCode(localUserId: EpicAccountId): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_Platform_GetActiveLocaleCode", listOf(handle, localUserId.raw, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun getOverrideCountryCode(): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_Platform_GetOverrideCountryCode", listOf(handle, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun getOverrideLocaleCode(): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_Platform_GetOverrideLocaleCode", listOf(handle, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun setOverrideCountryCode(newCountryCode: String?): EosResult = Arena.ofConfined().use { arena ->
    EosResult.fromValue(Native.invoke("EOS_Platform_SetOverrideCountryCode", listOf(handle, if (newCountryCode == null) 0L else arena.allocateFrom(newCountryCode).address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)
  }

  public fun setOverrideLocaleCode(newLocaleCode: String?): EosResult = Arena.ofConfined().use { arena ->
    EosResult.fromValue(Native.invoke("EOS_Platform_SetOverrideLocaleCode", listOf(handle, if (newLocaleCode == null) 0L else arena.allocateFrom(newLocaleCode).address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)
  }

  public fun checkForLauncherAndRestart(): EosResult = EosResult.fromValue(Native.invoke("EOS_Platform_CheckForLauncherAndRestart", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getDesktopCrossplayStatus(options: PlatformGetDesktopCrossplayStatusOptions, outDesktopCrossplayStatusInfo: PlatformDesktopCrossplayStatusInfo): EosResult = EosResult.fromValue(Native.invoke("EOS_Platform_GetDesktopCrossplayStatus", listOf(handle, options.address, outDesktopCrossplayStatusInfo.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setApplicationStatus(newStatus: EApplicationStatus): EosResult = EosResult.fromValue(Native.invoke("EOS_Platform_SetApplicationStatus", listOf(handle, newStatus.value), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT), ValueLayout.JAVA_INT) as Int)

  public fun getApplicationStatus(): EApplicationStatus = EApplicationStatus(Native.invoke("EOS_Platform_GetApplicationStatus", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setNetworkStatus(newStatus: ENetworkStatus): EosResult = EosResult.fromValue(Native.invoke("EOS_Platform_SetNetworkStatus", listOf(handle, newStatus.value), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT), ValueLayout.JAVA_INT) as Int)

  public fun getNetworkStatus(): ENetworkStatus = ENetworkStatus(Native.invoke("EOS_Platform_GetNetworkStatus", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public companion object {
    public val NULL: HPlatform = HPlatform(0)
  }
}

@JvmInline
public value class HPlayerDataStorage(
  public val handle: Long,
) {
  public fun queryFile(queryFileOptions: PlayerDataStorageQueryFileOptions, completionCallback: (PlayerDataStorageQueryFileCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = PlayerDataStorageQueryFileCallbackInfo(data.address()); completionCallback(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_PlayerDataStorage_QueryFile", listOf(handle, queryFileOptions.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryFileList(queryFileListOptions: PlayerDataStorageQueryFileListOptions, completionCallback: (PlayerDataStorageQueryFileListCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = PlayerDataStorageQueryFileListCallbackInfo(data.address()); completionCallback(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_PlayerDataStorage_QueryFileList", listOf(handle, queryFileListOptions.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun copyFileMetadataByFilename(copyFileMetadataOptions: PlayerDataStorageCopyFileMetadataByFilenameOptions): PlayerDataStorageFileMetadata = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_PlayerDataStorage_CopyFileMetadataByFilename", listOf(handle, copyFileMetadataOptions.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    PlayerDataStorageFileMetadata(RawMemory.getLong(out))
  }

  public fun getFileMetadataCount(getFileMetadataCountOptions: PlayerDataStorageGetFileMetadataCountOptions): Int = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_PlayerDataStorage_GetFileMetadataCount", listOf(handle, getFileMetadataCountOptions.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RawMemory.getInt(out)
  }

  public fun copyFileMetadataAtIndex(copyFileMetadataOptions: PlayerDataStorageCopyFileMetadataAtIndexOptions): PlayerDataStorageFileMetadata = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_PlayerDataStorage_CopyFileMetadataAtIndex", listOf(handle, copyFileMetadataOptions.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    PlayerDataStorageFileMetadata(RawMemory.getLong(out))
  }

  public fun duplicateFile(duplicateOptions: PlayerDataStorageDuplicateFileOptions, completionCallback: (PlayerDataStorageDuplicateFileCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = PlayerDataStorageDuplicateFileCallbackInfo(data.address()); completionCallback(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_PlayerDataStorage_DuplicateFile", listOf(handle, duplicateOptions.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun deleteFile(deleteOptions: PlayerDataStorageDeleteFileOptions, completionCallback: (PlayerDataStorageDeleteFileCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = PlayerDataStorageDeleteFileCallbackInfo(data.address()); completionCallback(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_PlayerDataStorage_DeleteFile", listOf(handle, deleteOptions.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun readFile(readOptions: PlayerDataStorageReadFileOptions, completionCallback: (PlayerDataStorageReadFileCallbackInfo) -> Unit): HPlayerDataStorageFileTransferRequest {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = PlayerDataStorageReadFileCallbackInfo(data.address()); completionCallback(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    return HPlayerDataStorageFileTransferRequest(Native.invoke("EOS_PlayerDataStorage_ReadFile", listOf(handle, readOptions.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun writeFile(writeOptions: PlayerDataStorageWriteFileOptions, completionCallback: (PlayerDataStorageWriteFileCallbackInfo) -> Unit): HPlayerDataStorageFileTransferRequest {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = PlayerDataStorageWriteFileCallbackInfo(data.address()); completionCallback(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    return HPlayerDataStorageFileTransferRequest(Native.invoke("EOS_PlayerDataStorage_WriteFile", listOf(handle, writeOptions.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun deleteCache(options: PlayerDataStorageDeleteCacheOptions, completionCallback: (PlayerDataStorageDeleteCacheCallbackInfo) -> Unit): EosResult {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = PlayerDataStorageDeleteCacheCallbackInfo(data.address()); completionCallback(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    return EosResult.fromValue(Native.invoke("EOS_PlayerDataStorage_DeleteCache", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
  }

  public companion object {
    public val NULL: HPlayerDataStorage = HPlayerDataStorage(0)
  }
}

@JvmInline
public value class HPlayerDataStorageFileTransferRequest(
  public val handle: Long,
) {
  public fun getFileRequestState(): EosResult = EosResult.fromValue(Native.invoke("EOS_PlayerDataStorageFileTransferRequest_GetFileRequestState", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getFilename(
    filenameStringBufferSizeBytes: Int,
    outStringBuffer: String?,
    outStringLength: Long,
  ): EosResult = Arena.ofConfined().use { arena ->
    EosResult.fromValue(Native.invoke("EOS_PlayerDataStorageFileTransferRequest_GetFilename", listOf(handle, filenameStringBufferSizeBytes, if (outStringBuffer == null) 0L else arena.allocateFrom(outStringBuffer).address(), outStringLength), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)
  }

  public fun cancelRequest(): EosResult = EosResult.fromValue(Native.invoke("EOS_PlayerDataStorageFileTransferRequest_CancelRequest", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun release() {
    Native.invokeVoid("EOS_PlayerDataStorageFileTransferRequest_Release", listOf(handle), listOf(ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HPlayerDataStorageFileTransferRequest =
        HPlayerDataStorageFileTransferRequest(0)
  }
}

@JvmInline
public value class HPresence(
  public val handle: Long,
) {
  public fun queryPresence(options: PresenceQueryPresenceOptions, completionDelegate: (PresenceQueryPresenceCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = PresenceQueryPresenceCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_Presence_QueryPresence", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun hasPresence(options: PresenceHasPresenceOptions): Boolean = (Native.invoke("EOS_Presence_HasPresence", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int) != 0

  public fun copyPresence(options: PresenceCopyPresenceOptions): PresenceInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Presence_CopyPresence", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    PresenceInfo(RawMemory.getLong(out))
  }

  public fun createPresenceModification(options: PresenceCreatePresenceModificationOptions): HPresenceModification = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Presence_CreatePresenceModification", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HPresenceModification(RawMemory.getLong(out))
  }

  public fun setPresence(options: PresenceSetPresenceOptions, completionDelegate: (PresenceSetPresenceCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = PresenceSetPresenceCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_Presence_SetPresence", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun addNotifyOnPresenceChanged(options: PresenceAddNotifyOnPresenceChangedOptions, notificationHandler: (PresencePresenceChangedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = PresencePresenceChangedCallbackInfo(data.address()); notificationHandler(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Presence_AddNotifyOnPresenceChanged", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyOnPresenceChanged(notificationId: Long) {
    Native.invokeVoid("EOS_Presence_RemoveNotifyOnPresenceChanged", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyJoinGameAccepted(options: PresenceAddNotifyJoinGameAcceptedOptions, notificationFn: (PresenceJoinGameAcceptedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = PresenceJoinGameAcceptedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Presence_AddNotifyJoinGameAccepted", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyJoinGameAccepted(inId: Long) {
    Native.invokeVoid("EOS_Presence_RemoveNotifyJoinGameAccepted", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun getJoinInfo(options: PresenceGetJoinInfoOptions): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_Presence_GetJoinInfo", listOf(handle, options.address, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public companion object {
    public val NULL: HPresence = HPresence(0)
  }
}

@JvmInline
public value class HPresenceModification(
  public val handle: Long,
) {
  public fun setStatus(options: PresenceModificationSetStatusOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_PresenceModification_SetStatus", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setTemplateId(options: PresenceModificationSetTemplateIdOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_PresenceModification_SetTemplateId", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setTemplateData(options: PresenceModificationSetTemplateDataOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_PresenceModification_SetTemplateData", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setRawRichText(options: PresenceModificationSetRawRichTextOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_PresenceModification_SetRawRichText", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setData(options: PresenceModificationSetDataOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_PresenceModification_SetData", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun deleteData(options: PresenceModificationDeleteDataOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_PresenceModification_DeleteData", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setJoinInfo(options: PresenceModificationSetJoinInfoOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_PresenceModification_SetJoinInfo", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun release() {
    Native.invokeVoid("EOS_PresenceModification_Release", listOf(handle), listOf(ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HPresenceModification = HPresenceModification(0)
  }
}

@JvmInline
public value class HProgressionSnapshot(
  public val handle: Long,
) {
  public fun beginSnapshot(options: ProgressionSnapshotBeginSnapshotOptions): Int = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_ProgressionSnapshot_BeginSnapshot", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RawMemory.getInt(out)
  }

  public fun addProgression(options: ProgressionSnapshotAddProgressionOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_ProgressionSnapshot_AddProgression", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun submitSnapshot(options: ProgressionSnapshotSubmitSnapshotOptions, completionDelegate: (ProgressionSnapshotSubmitSnapshotCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ProgressionSnapshotSubmitSnapshotCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_ProgressionSnapshot_SubmitSnapshot", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun endSnapshot(options: ProgressionSnapshotEndSnapshotOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_ProgressionSnapshot_EndSnapshot", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun deleteSnapshot(options: ProgressionSnapshotDeleteSnapshotOptions, completionDelegate: (ProgressionSnapshotDeleteSnapshotCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ProgressionSnapshotDeleteSnapshotCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_ProgressionSnapshot_DeleteSnapshot", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public companion object {
    public val NULL: HProgressionSnapshot = HProgressionSnapshot(0)
  }
}

@JvmInline
public value class HRTC(
  public val handle: Long,
) {
  public fun getAudioInterface(): HRTCAudio = HRTCAudio(Native.invoke("EOS_RTC_GetAudioInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getDataInterface(): HRTCData = HRTCData(Native.invoke("EOS_RTC_GetDataInterface", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun joinRoom(options: RTCJoinRoomOptions, completionDelegate: (RTCJoinRoomCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCJoinRoomCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTC_JoinRoom", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun leaveRoom(options: RTCLeaveRoomOptions, completionDelegate: (RTCLeaveRoomCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCLeaveRoomCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTC_LeaveRoom", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun blockParticipant(options: RTCBlockParticipantOptions, completionDelegate: (RTCBlockParticipantCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCBlockParticipantCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTC_BlockParticipant", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun addNotifyDisconnected(options: RTCAddNotifyDisconnectedOptions, completionDelegate: (RTCDisconnectedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCDisconnectedCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    return (Native.invoke("EOS_RTC_AddNotifyDisconnected", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyDisconnected(notificationId: Long) {
    Native.invokeVoid("EOS_RTC_RemoveNotifyDisconnected", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyParticipantStatusChanged(options: RTCAddNotifyParticipantStatusChangedOptions, completionDelegate: (RTCParticipantStatusChangedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCParticipantStatusChangedCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    return (Native.invoke("EOS_RTC_AddNotifyParticipantStatusChanged", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyParticipantStatusChanged(notificationId: Long) {
    Native.invokeVoid("EOS_RTC_RemoveNotifyParticipantStatusChanged", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyRoomBeforeJoin(options: RTCAddNotifyRoomBeforeJoinOptions, completionDelegate: (RTCRoomBeforeJoinCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCRoomBeforeJoinCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    return (Native.invoke("EOS_RTC_AddNotifyRoomBeforeJoin", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyRoomBeforeJoin(notificationId: Long) {
    Native.invokeVoid("EOS_RTC_RemoveNotifyRoomBeforeJoin", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun setSetting(options: RTCSetSettingOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_RTC_SetSetting", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setRoomSetting(options: RTCSetRoomSettingOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_RTC_SetRoomSetting", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun addNotifyRoomStatisticsUpdated(options: RTCAddNotifyRoomStatisticsUpdatedOptions, completionDelegate: (RTCRoomStatisticsUpdatedInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCRoomStatisticsUpdatedInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    return (Native.invoke("EOS_RTC_AddNotifyRoomStatisticsUpdated", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyRoomStatisticsUpdated(notificationId: Long) {
    Native.invokeVoid("EOS_RTC_RemoveNotifyRoomStatisticsUpdated", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HRTC = HRTC(0)
  }
}

@JvmInline
public value class HRTCAdmin(
  public val handle: Long,
) {
  public fun queryJoinRoomToken(options: RTCAdminQueryJoinRoomTokenOptions, completionDelegate: (RTCAdminQueryJoinRoomTokenCompleteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAdminQueryJoinRoomTokenCompleteCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAdmin_QueryJoinRoomToken", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun copyUserTokenByIndex(options: RTCAdminCopyUserTokenByIndexOptions): RTCAdminUserToken = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_RTCAdmin_CopyUserTokenByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RTCAdminUserToken(RawMemory.getLong(out))
  }

  public fun copyUserTokenByUserId(options: RTCAdminCopyUserTokenByUserIdOptions): RTCAdminUserToken = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_RTCAdmin_CopyUserTokenByUserId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RTCAdminUserToken(RawMemory.getLong(out))
  }

  public fun kick(options: RTCAdminKickOptions, completionDelegate: (RTCAdminKickCompleteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAdminKickCompleteCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAdmin_Kick", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun setParticipantHardMute(options: RTCAdminSetParticipantHardMuteOptions, completionDelegate: (RTCAdminSetParticipantHardMuteCompleteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAdminSetParticipantHardMuteCompleteCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAdmin_SetParticipantHardMute", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public companion object {
    public val NULL: HRTCAdmin = HRTCAdmin(0)
  }
}

@JvmInline
public value class HRTCAudio(
  public val handle: Long,
) {
  public fun sendAudio(options: RTCAudioSendAudioOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_RTCAudio_SendAudio", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun updateSending(options: RTCAudioUpdateSendingOptions, completionDelegate: (RTCAudioUpdateSendingCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioUpdateSendingCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAudio_UpdateSending", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun updateReceiving(options: RTCAudioUpdateReceivingOptions, completionDelegate: (RTCAudioUpdateReceivingCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioUpdateReceivingCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAudio_UpdateReceiving", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun updateSendingVolume(options: RTCAudioUpdateSendingVolumeOptions, completionDelegate: (RTCAudioUpdateSendingVolumeCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioUpdateSendingVolumeCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAudio_UpdateSendingVolume", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun updateReceivingVolume(options: RTCAudioUpdateReceivingVolumeOptions, completionDelegate: (RTCAudioUpdateReceivingVolumeCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioUpdateReceivingVolumeCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAudio_UpdateReceivingVolume", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun updateParticipantVolume(options: RTCAudioUpdateParticipantVolumeOptions, completionDelegate: (RTCAudioUpdateParticipantVolumeCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioUpdateParticipantVolumeCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAudio_UpdateParticipantVolume", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun addNotifyParticipantUpdated(options: RTCAudioAddNotifyParticipantUpdatedOptions, completionDelegate: (RTCAudioParticipantUpdatedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioParticipantUpdatedCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    return (Native.invoke("EOS_RTCAudio_AddNotifyParticipantUpdated", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyParticipantUpdated(notificationId: Long) {
    Native.invokeVoid("EOS_RTCAudio_RemoveNotifyParticipantUpdated", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyAudioDevicesChanged(options: RTCAudioAddNotifyAudioDevicesChangedOptions, completionDelegate: (RTCAudioAudioDevicesChangedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioAudioDevicesChangedCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    return (Native.invoke("EOS_RTCAudio_AddNotifyAudioDevicesChanged", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyAudioDevicesChanged(notificationId: Long) {
    Native.invokeVoid("EOS_RTCAudio_RemoveNotifyAudioDevicesChanged", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyAudioInputState(options: RTCAudioAddNotifyAudioInputStateOptions, completionDelegate: (RTCAudioAudioInputStateCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioAudioInputStateCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    return (Native.invoke("EOS_RTCAudio_AddNotifyAudioInputState", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyAudioInputState(notificationId: Long) {
    Native.invokeVoid("EOS_RTCAudio_RemoveNotifyAudioInputState", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyAudioOutputState(options: RTCAudioAddNotifyAudioOutputStateOptions, completionDelegate: (RTCAudioAudioOutputStateCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioAudioOutputStateCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    return (Native.invoke("EOS_RTCAudio_AddNotifyAudioOutputState", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyAudioOutputState(notificationId: Long) {
    Native.invokeVoid("EOS_RTCAudio_RemoveNotifyAudioOutputState", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyAudioBeforeSend(options: RTCAudioAddNotifyAudioBeforeSendOptions, completionDelegate: (RTCAudioAudioBeforeSendCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioAudioBeforeSendCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    return (Native.invoke("EOS_RTCAudio_AddNotifyAudioBeforeSend", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyAudioBeforeSend(notificationId: Long) {
    Native.invokeVoid("EOS_RTCAudio_RemoveNotifyAudioBeforeSend", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyAudioBeforeRender(options: RTCAudioAddNotifyAudioBeforeRenderOptions, completionDelegate: (RTCAudioAudioBeforeRenderCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioAudioBeforeRenderCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    return (Native.invoke("EOS_RTCAudio_AddNotifyAudioBeforeRender", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyAudioBeforeRender(notificationId: Long) {
    Native.invokeVoid("EOS_RTCAudio_RemoveNotifyAudioBeforeRender", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun registerPlatformUser(options: RTCAudioRegisterPlatformUserOptions, completionDelegate: (RTCAudioOnRegisterPlatformUserCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioOnRegisterPlatformUserCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAudio_RegisterPlatformUser", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun unregisterPlatformUser(options: RTCAudioUnregisterPlatformUserOptions, completionDelegate: (RTCAudioOnUnregisterPlatformUserCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioOnUnregisterPlatformUserCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAudio_UnregisterPlatformUser", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryInputDevicesInformation(options: RTCAudioQueryInputDevicesInformationOptions, completionDelegate: (RTCAudioOnQueryInputDevicesInformationCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioOnQueryInputDevicesInformationCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAudio_QueryInputDevicesInformation", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getInputDevicesCount(options: RTCAudioGetInputDevicesCountOptions): Int = (Native.invoke("EOS_RTCAudio_GetInputDevicesCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyInputDeviceInformationByIndex(options: RTCAudioCopyInputDeviceInformationByIndexOptions): RTCAudioInputDeviceInformation = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_RTCAudio_CopyInputDeviceInformationByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RTCAudioInputDeviceInformation(RawMemory.getLong(out))
  }

  public fun queryOutputDevicesInformation(options: RTCAudioQueryOutputDevicesInformationOptions, completionDelegate: (RTCAudioOnQueryOutputDevicesInformationCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioOnQueryOutputDevicesInformationCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAudio_QueryOutputDevicesInformation", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getOutputDevicesCount(options: RTCAudioGetOutputDevicesCountOptions): Int = (Native.invoke("EOS_RTCAudio_GetOutputDevicesCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyOutputDeviceInformationByIndex(options: RTCAudioCopyOutputDeviceInformationByIndexOptions): RTCAudioOutputDeviceInformation = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_RTCAudio_CopyOutputDeviceInformationByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    RTCAudioOutputDeviceInformation(RawMemory.getLong(out))
  }

  public fun setInputDeviceSettings(options: RTCAudioSetInputDeviceSettingsOptions, completionDelegate: (RTCAudioOnSetInputDeviceSettingsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioOnSetInputDeviceSettingsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAudio_SetInputDeviceSettings", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun setOutputDeviceSettings(options: RTCAudioSetOutputDeviceSettingsOptions, completionDelegate: (RTCAudioOnSetOutputDeviceSettingsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCAudioOnSetOutputDeviceSettingsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCAudio_SetOutputDeviceSettings", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun registerPlatformAudioUser(options: RTCAudioRegisterPlatformAudioUserOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_RTCAudio_RegisterPlatformAudioUser", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun unregisterPlatformAudioUser(options: RTCAudioUnregisterPlatformAudioUserOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_RTCAudio_UnregisterPlatformAudioUser", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getAudioInputDevicesCount(options: RTCAudioGetAudioInputDevicesCountOptions): Int = (Native.invoke("EOS_RTCAudio_GetAudioInputDevicesCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getAudioInputDeviceByIndex(options: RTCAudioGetAudioInputDeviceByIndexOptions): RTCAudioAudioInputDeviceInfo = RTCAudioAudioInputDeviceInfo(Native.invoke("EOS_RTCAudio_GetAudioInputDeviceByIndex", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun getAudioOutputDevicesCount(options: RTCAudioGetAudioOutputDevicesCountOptions): Int = (Native.invoke("EOS_RTCAudio_GetAudioOutputDevicesCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getAudioOutputDeviceByIndex(options: RTCAudioGetAudioOutputDeviceByIndexOptions): RTCAudioAudioOutputDeviceInfo = RTCAudioAudioOutputDeviceInfo(Native.invoke("EOS_RTCAudio_GetAudioOutputDeviceByIndex", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun setAudioInputSettings(options: RTCAudioSetAudioInputSettingsOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_RTCAudio_SetAudioInputSettings", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setAudioOutputSettings(options: RTCAudioSetAudioOutputSettingsOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_RTCAudio_SetAudioOutputSettings", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public companion object {
    public val NULL: HRTCAudio = HRTCAudio(0)
  }
}

@JvmInline
public value class HRTCData(
  public val handle: Long,
) {
  public fun addNotifyDataReceived(options: RTCDataAddNotifyDataReceivedOptions, completionDelegate: (RTCDataDataReceivedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCDataDataReceivedCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    return (Native.invoke("EOS_RTCData_AddNotifyDataReceived", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyDataReceived(notificationId: Long) {
    Native.invokeVoid("EOS_RTCData_RemoveNotifyDataReceived", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun sendData(options: RTCDataSendDataOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_RTCData_SendData", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun updateSending(options: RTCDataUpdateSendingOptions, completionDelegate: (RTCDataUpdateSendingCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCDataUpdateSendingCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCData_UpdateSending", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun updateReceiving(options: RTCDataUpdateReceivingOptions, completionDelegate: (RTCDataUpdateReceivingCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCDataUpdateReceivingCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_RTCData_UpdateReceiving", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun addNotifyParticipantUpdated(options: RTCDataAddNotifyParticipantUpdatedOptions, completionDelegate: (RTCDataParticipantUpdatedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = RTCDataParticipantUpdatedCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    return (Native.invoke("EOS_RTCData_AddNotifyParticipantUpdated", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyParticipantUpdated(notificationId: Long) {
    Native.invokeVoid("EOS_RTCData_RemoveNotifyParticipantUpdated", listOf(handle, notificationId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HRTCData = HRTCData(0)
  }
}

@JvmInline
public value class HReports(
  public val handle: Long,
) {
  public fun sendPlayerBehaviorReport(options: ReportsSendPlayerBehaviorReportOptions, completionDelegate: (ReportsSendPlayerBehaviorReportCompleteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = ReportsSendPlayerBehaviorReportCompleteCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_Reports_SendPlayerBehaviorReport", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public companion object {
    public val NULL: HReports = HReports(0)
  }
}

@JvmInline
public value class HSanctions(
  public val handle: Long,
) {
  public fun queryActivePlayerSanctions(options: SanctionsQueryActivePlayerSanctionsOptions, completionDelegate: (SanctionsQueryActivePlayerSanctionsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SanctionsQueryActivePlayerSanctionsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Sanctions_QueryActivePlayerSanctions", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getPlayerSanctionCount(options: SanctionsGetPlayerSanctionCountOptions): Int = (Native.invoke("EOS_Sanctions_GetPlayerSanctionCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyPlayerSanctionByIndex(options: SanctionsCopyPlayerSanctionByIndexOptions): SanctionsPlayerSanction = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Sanctions_CopyPlayerSanctionByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    SanctionsPlayerSanction(RawMemory.getLong(out))
  }

  public fun createPlayerSanctionAppeal(options: SanctionsCreatePlayerSanctionAppealOptions, completionDelegate: (SanctionsCreatePlayerSanctionAppealCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SanctionsCreatePlayerSanctionAppealCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Sanctions_CreatePlayerSanctionAppeal", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public companion object {
    public val NULL: HSanctions = HSanctions(0)
  }
}

@JvmInline
public value class HSessionDetails(
  public val handle: Long,
) {
  public fun copyInfo(options: SessionDetailsCopyInfoOptions): SessionDetailsInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_SessionDetails_CopyInfo", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    SessionDetailsInfo(RawMemory.getLong(out))
  }

  public fun getSessionAttributeCount(options: SessionDetailsGetSessionAttributeCountOptions): Int = (Native.invoke("EOS_SessionDetails_GetSessionAttributeCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copySessionAttributeByIndex(options: SessionDetailsCopySessionAttributeByIndexOptions): SessionDetailsAttribute = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_SessionDetails_CopySessionAttributeByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    SessionDetailsAttribute(RawMemory.getLong(out))
  }

  public fun copySessionAttributeByKey(options: SessionDetailsCopySessionAttributeByKeyOptions): SessionDetailsAttribute = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_SessionDetails_CopySessionAttributeByKey", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    SessionDetailsAttribute(RawMemory.getLong(out))
  }

  public fun release() {
    Native.invokeVoid("EOS_SessionDetails_Release", listOf(handle), listOf(ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HSessionDetails = HSessionDetails(0)
  }
}

@JvmInline
public value class HSessionModification(
  public val handle: Long,
) {
  public fun setBucketId(options: SessionModificationSetBucketIdOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionModification_SetBucketId", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setHostAddress(options: SessionModificationSetHostAddressOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionModification_SetHostAddress", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setPermissionLevel(options: SessionModificationSetPermissionLevelOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionModification_SetPermissionLevel", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setJoinInProgressAllowed(options: SessionModificationSetJoinInProgressAllowedOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionModification_SetJoinInProgressAllowed", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setMaxPlayers(options: SessionModificationSetMaxPlayersOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionModification_SetMaxPlayers", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setInvitesAllowed(options: SessionModificationSetInvitesAllowedOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionModification_SetInvitesAllowed", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setAllowedPlatformIds(options: SessionModificationSetAllowedPlatformIdsOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionModification_SetAllowedPlatformIds", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun addAttribute(options: SessionModificationAddAttributeOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionModification_AddAttribute", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun removeAttribute(options: SessionModificationRemoveAttributeOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionModification_RemoveAttribute", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun release() {
    Native.invokeVoid("EOS_SessionModification_Release", listOf(handle), listOf(ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HSessionModification = HSessionModification(0)
  }
}

@JvmInline
public value class HSessionSearch(
  public val handle: Long,
) {
  public fun setSessionId(options: SessionSearchSetSessionIdOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionSearch_SetSessionId", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setTargetUserId(options: SessionSearchSetTargetUserIdOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionSearch_SetTargetUserId", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setParameter(options: SessionSearchSetParameterOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionSearch_SetParameter", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun removeParameter(options: SessionSearchRemoveParameterOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionSearch_RemoveParameter", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun setMaxResults(options: SessionSearchSetMaxResultsOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_SessionSearch_SetMaxResults", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun find(options: SessionSearchFindOptions, completionDelegate: (SessionSearchFindCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionSearchFindCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_SessionSearch_Find", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getSearchResultCount(options: SessionSearchGetSearchResultCountOptions): Int = (Native.invoke("EOS_SessionSearch_GetSearchResultCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copySearchResultByIndex(options: SessionSearchCopySearchResultByIndexOptions): HSessionDetails = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_SessionSearch_CopySearchResultByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HSessionDetails(RawMemory.getLong(out))
  }

  public fun release() {
    Native.invokeVoid("EOS_SessionSearch_Release", listOf(handle), listOf(ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HSessionSearch = HSessionSearch(0)
  }
}

@JvmInline
public value class HSessions(
  public val handle: Long,
) {
  public fun createSessionModification(options: SessionsCreateSessionModificationOptions): HSessionModification = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Sessions_CreateSessionModification", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HSessionModification(RawMemory.getLong(out))
  }

  public fun updateSessionModification(options: SessionsUpdateSessionModificationOptions): HSessionModification = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Sessions_UpdateSessionModification", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HSessionModification(RawMemory.getLong(out))
  }

  public fun updateSession(options: SessionsUpdateSessionOptions, completionDelegate: (SessionsUpdateSessionCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsUpdateSessionCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Sessions_UpdateSession", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun destroySession(options: SessionsDestroySessionOptions, completionDelegate: (SessionsDestroySessionCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsDestroySessionCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Sessions_DestroySession", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun joinSession(options: SessionsJoinSessionOptions, completionDelegate: (SessionsJoinSessionCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsJoinSessionCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Sessions_JoinSession", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun startSession(options: SessionsStartSessionOptions, completionDelegate: (SessionsStartSessionCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsStartSessionCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Sessions_StartSession", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun endSession(options: SessionsEndSessionOptions, completionDelegate: (SessionsEndSessionCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsEndSessionCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Sessions_EndSession", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun registerPlayers(options: SessionsRegisterPlayersOptions, completionDelegate: (SessionsRegisterPlayersCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsRegisterPlayersCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Sessions_RegisterPlayers", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun unregisterPlayers(options: SessionsUnregisterPlayersOptions, completionDelegate: (SessionsUnregisterPlayersCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsUnregisterPlayersCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Sessions_UnregisterPlayers", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun sendInvite(options: SessionsSendInviteOptions, completionDelegate: (SessionsSendInviteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsSendInviteCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Sessions_SendInvite", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun rejectInvite(options: SessionsRejectInviteOptions, completionDelegate: (SessionsRejectInviteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsRejectInviteCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Sessions_RejectInvite", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryInvites(options: SessionsQueryInvitesOptions, completionDelegate: (SessionsQueryInvitesCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsQueryInvitesCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_Sessions_QueryInvites", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getInviteCount(options: SessionsGetInviteCountOptions): Int = (Native.invoke("EOS_Sessions_GetInviteCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getInviteIdByIndex(options: SessionsGetInviteIdByIndexOptions): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_Sessions_GetInviteIdByIndex", listOf(handle, options.address, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun createSessionSearch(options: SessionsCreateSessionSearchOptions): HSessionSearch = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Sessions_CreateSessionSearch", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HSessionSearch(RawMemory.getLong(out))
  }

  public fun copyActiveSessionHandle(options: SessionsCopyActiveSessionHandleOptions): HActiveSession = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Sessions_CopyActiveSessionHandle", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HActiveSession(RawMemory.getLong(out))
  }

  public fun addNotifySessionInviteReceived(options: SessionsAddNotifySessionInviteReceivedOptions, notificationFn: (SessionsSessionInviteReceivedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsSessionInviteReceivedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Sessions_AddNotifySessionInviteReceived", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifySessionInviteReceived(inId: Long) {
    Native.invokeVoid("EOS_Sessions_RemoveNotifySessionInviteReceived", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifySessionInviteAccepted(options: SessionsAddNotifySessionInviteAcceptedOptions, notificationFn: (SessionsSessionInviteAcceptedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsSessionInviteAcceptedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Sessions_AddNotifySessionInviteAccepted", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifySessionInviteAccepted(inId: Long) {
    Native.invokeVoid("EOS_Sessions_RemoveNotifySessionInviteAccepted", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifySessionInviteRejected(options: SessionsAddNotifySessionInviteRejectedOptions, notificationFn: (SessionsSessionInviteRejectedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsSessionInviteRejectedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Sessions_AddNotifySessionInviteRejected", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifySessionInviteRejected(inId: Long) {
    Native.invokeVoid("EOS_Sessions_RemoveNotifySessionInviteRejected", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifyJoinSessionAccepted(options: SessionsAddNotifyJoinSessionAcceptedOptions, notificationFn: (SessionsJoinSessionAcceptedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsJoinSessionAcceptedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Sessions_AddNotifyJoinSessionAccepted", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyJoinSessionAccepted(inId: Long) {
    Native.invokeVoid("EOS_Sessions_RemoveNotifyJoinSessionAccepted", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun copySessionHandleByInviteId(options: SessionsCopySessionHandleByInviteIdOptions): HSessionDetails = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Sessions_CopySessionHandleByInviteId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HSessionDetails(RawMemory.getLong(out))
  }

  public fun copySessionHandleByUiEventId(options: SessionsCopySessionHandleByUiEventIdOptions): HSessionDetails = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Sessions_CopySessionHandleByUiEventId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HSessionDetails(RawMemory.getLong(out))
  }

  public fun copySessionHandleForPresence(options: SessionsCopySessionHandleForPresenceOptions): HSessionDetails = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Sessions_CopySessionHandleForPresence", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HSessionDetails(RawMemory.getLong(out))
  }

  public fun isUserInSession(options: SessionsIsUserInSessionOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_Sessions_IsUserInSession", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun dumpSessionState(options: SessionsDumpSessionStateOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_Sessions_DumpSessionState", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun addNotifyLeaveSessionRequested(options: SessionsAddNotifyLeaveSessionRequestedOptions, notificationFn: (SessionsLeaveSessionRequestedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsLeaveSessionRequestedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Sessions_AddNotifyLeaveSessionRequested", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyLeaveSessionRequested(inId: Long) {
    Native.invokeVoid("EOS_Sessions_RemoveNotifyLeaveSessionRequested", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun addNotifySendSessionNativeInviteRequested(options: SessionsAddNotifySendSessionNativeInviteRequestedOptions, notificationFn: (SessionsSendSessionNativeInviteRequestedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = SessionsSendSessionNativeInviteRequestedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_Sessions_AddNotifySendSessionNativeInviteRequested", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifySendSessionNativeInviteRequested(inId: Long) {
    Native.invokeVoid("EOS_Sessions_RemoveNotifySendSessionNativeInviteRequested", listOf(handle, inId), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HSessions = HSessions(0)
  }
}

@JvmInline
public value class HStats(
  public val handle: Long,
) {
  public fun ingestStat(options: StatsIngestStatOptions, completionDelegate: (StatsIngestStatCompleteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = StatsIngestStatCompleteCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_Stats_IngestStat", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryStats(options: StatsQueryStatsOptions, completionDelegate: (StatsOnQueryStatsCompleteCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = StatsOnQueryStatsCompleteCallbackInfo(data.address()); completionDelegate(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_Stats_QueryStats", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getStatsCount(options: StatsGetStatCountOptions): Int = (Native.invoke("EOS_Stats_GetStatsCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyStatByIndex(options: StatsCopyStatByIndexOptions): StatsStat = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Stats_CopyStatByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    StatsStat(RawMemory.getLong(out))
  }

  public fun copyStatByName(options: StatsCopyStatByNameOptions): StatsStat = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Stats_CopyStatByName", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    StatsStat(RawMemory.getLong(out))
  }

  public companion object {
    public val NULL: HStats = HStats(0)
  }
}

@JvmInline
public value class HTitleStorage(
  public val handle: Long,
) {
  public fun queryFile(options: TitleStorageQueryFileOptions, completionCallback: (TitleStorageQueryFileCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = TitleStorageQueryFileCallbackInfo(data.address()); completionCallback(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_TitleStorage_QueryFile", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryFileList(options: TitleStorageQueryFileListOptions, completionCallback: (TitleStorageQueryFileListCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = TitleStorageQueryFileListCallbackInfo(data.address()); completionCallback(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    Native.invokeVoid("EOS_TitleStorage_QueryFileList", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun copyFileMetadataByFilename(options: TitleStorageCopyFileMetadataByFilenameOptions): TitleStorageFileMetadata = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_TitleStorage_CopyFileMetadataByFilename", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    TitleStorageFileMetadata(RawMemory.getLong(out))
  }

  public fun getFileMetadataCount(options: TitleStorageGetFileMetadataCountOptions): Int = (Native.invoke("EOS_TitleStorage_GetFileMetadataCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyFileMetadataAtIndex(options: TitleStorageCopyFileMetadataAtIndexOptions): TitleStorageFileMetadata = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_TitleStorage_CopyFileMetadataAtIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    TitleStorageFileMetadata(RawMemory.getLong(out))
  }

  public fun readFile(options: TitleStorageReadFileOptions, completionCallback: (TitleStorageReadFileCallbackInfo) -> Unit): HTitleStorageFileTransferRequest {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = TitleStorageReadFileCallbackInfo(data.address()); completionCallback(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    return HTitleStorageFileTransferRequest(Native.invoke("EOS_TitleStorage_ReadFile", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun deleteCache(options: TitleStorageDeleteCacheOptions, completionCallback: (TitleStorageDeleteCacheCallbackInfo) -> Unit): EosResult {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = TitleStorageDeleteCacheCallbackInfo(data.address()); completionCallback(info); if (info.resultCode != EosResult.OperationWillRetry) CallbackStubs.release(stubId) }
    stubId = stub.id
    return EosResult.fromValue(Native.invoke("EOS_TitleStorage_DeleteCache", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
  }

  public companion object {
    public val NULL: HTitleStorage = HTitleStorage(0)
  }
}

@JvmInline
public value class HTitleStorageFileTransferRequest(
  public val handle: Long,
) {
  public fun getFileRequestState(): EosResult = EosResult.fromValue(Native.invoke("EOS_TitleStorageFileTransferRequest_GetFileRequestState", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getFilename(
    filenameStringBufferSizeBytes: Int,
    outStringBuffer: String?,
    outStringLength: Long,
  ): EosResult = Arena.ofConfined().use { arena ->
    EosResult.fromValue(Native.invoke("EOS_TitleStorageFileTransferRequest_GetFilename", listOf(handle, filenameStringBufferSizeBytes, if (outStringBuffer == null) 0L else arena.allocateFrom(outStringBuffer).address(), outStringLength), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)
  }

  public fun cancelRequest(): EosResult = EosResult.fromValue(Native.invoke("EOS_TitleStorageFileTransferRequest_CancelRequest", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun release() {
    Native.invokeVoid("EOS_TitleStorageFileTransferRequest_Release", listOf(handle), listOf(ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HTitleStorageFileTransferRequest = HTitleStorageFileTransferRequest(0)
  }
}

@JvmInline
public value class HUI(
  public val handle: Long,
) {
  public fun showFriends(options: UIShowFriendsOptions, completionDelegate: (UIShowFriendsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = UIShowFriendsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_UI_ShowFriends", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun hideFriends(options: UIHideFriendsOptions, completionDelegate: (UIHideFriendsCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = UIHideFriendsCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_UI_HideFriends", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun getFriendsVisible(options: UIGetFriendsVisibleOptions): Boolean = (Native.invoke("EOS_UI_GetFriendsVisible", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int) != 0

  public fun getFriendsExclusiveInput(options: UIGetFriendsExclusiveInputOptions): Boolean = (Native.invoke("EOS_UI_GetFriendsExclusiveInput", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int) != 0

  public fun addNotifyDisplaySettingsUpdated(options: UIAddNotifyDisplaySettingsUpdatedOptions, notificationFn: (UIOnDisplaySettingsUpdatedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = UIOnDisplaySettingsUpdatedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_UI_AddNotifyDisplaySettingsUpdated", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyDisplaySettingsUpdated(id: Long) {
    Native.invokeVoid("EOS_UI_RemoveNotifyDisplaySettingsUpdated", listOf(handle, id), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun setToggleFriendsKey(options: UISetToggleFriendsKeyOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_UI_SetToggleFriendsKey", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getToggleFriendsKey(options: UIGetToggleFriendsKeyOptions): Int = (Native.invoke("EOS_UI_GetToggleFriendsKey", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun isValidKeyCombination(keyCombination: Int): Boolean = (Native.invoke("EOS_UI_IsValidKeyCombination", listOf(handle, keyCombination), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT), ValueLayout.JAVA_INT) as Int) != 0

  public fun setToggleFriendsButton(options: UISetToggleFriendsButtonOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_UI_SetToggleFriendsButton", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getToggleFriendsButton(options: UIGetToggleFriendsButtonOptions): Int = (Native.invoke("EOS_UI_GetToggleFriendsButton", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun isValidButtonCombination(buttonCombination: Int): Boolean = (Native.invoke("EOS_UI_IsValidButtonCombination", listOf(handle, buttonCombination), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT), ValueLayout.JAVA_INT) as Int) != 0

  public fun setDisplayPreference(options: UISetDisplayPreferenceOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_UI_SetDisplayPreference", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun getNotificationLocationPreference(): UIENotificationLocation = UIENotificationLocation(Native.invoke("EOS_UI_GetNotificationLocationPreference", listOf(handle), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun acknowledgeEventId(options: UIAcknowledgeEventIdOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_UI_AcknowledgeEventId", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun reportInputState(options: UIReportInputStateOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_UI_ReportInputState", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun prePresent(options: UIPrePresentOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_UI_PrePresent", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun showBlockPlayer(options: UIShowBlockPlayerOptions, completionDelegate: (UIOnShowBlockPlayerCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = UIOnShowBlockPlayerCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_UI_ShowBlockPlayer", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun showReportPlayer(options: UIShowReportPlayerOptions, completionDelegate: (UIOnShowReportPlayerCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = UIOnShowReportPlayerCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_UI_ShowReportPlayer", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun pauseSocialOverlay(options: UIPauseSocialOverlayOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_UI_PauseSocialOverlay", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun isSocialOverlayPaused(options: UIIsSocialOverlayPausedOptions): Boolean = (Native.invoke("EOS_UI_IsSocialOverlayPaused", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int) != 0

  public fun addNotifyMemoryMonitor(options: UIAddNotifyMemoryMonitorOptions, notificationFn: (UIMemoryMonitorCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = UIMemoryMonitorCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_UI_AddNotifyMemoryMonitor", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyMemoryMonitor(id: Long) {
    Native.invokeVoid("EOS_UI_RemoveNotifyMemoryMonitor", listOf(handle, id), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public fun showNativeProfile(options: UIShowNativeProfileOptions, completionDelegate: (UIShowNativeProfileCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = UIShowNativeProfileCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_UI_ShowNativeProfile", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun configureOnScreenKeyboard(options: UIConfigureOnScreenKeyboardOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_UI_ConfigureOnScreenKeyboard", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun addNotifyOnScreenKeyboardRequested(options: UIAddNotifyOnScreenKeyboardRequestedOptions, notificationFn: (UIOnScreenKeyboardRequestedCallbackInfo) -> Unit): Long {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = UIOnScreenKeyboardRequestedCallbackInfo(data.address()); notificationFn(info) }
    stubId = stub.id
    return (Native.invoke("EOS_UI_AddNotifyOnScreenKeyboardRequested", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_LONG) as Long)
  }

  public fun removeNotifyOnScreenKeyboardRequested(id: Long) {
    Native.invokeVoid("EOS_UI_RemoveNotifyOnScreenKeyboardRequested", listOf(handle, id), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG))
  }

  public companion object {
    public val NULL: HUI = HUI(0)
  }
}

@JvmInline
public value class HUserInfo(
  public val handle: Long,
) {
  public fun queryUserInfo(options: UserInfoQueryUserInfoOptions, completionDelegate: (UserInfoQueryUserInfoCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = UserInfoQueryUserInfoCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_UserInfo_QueryUserInfo", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryUserInfoByDisplayName(options: UserInfoQueryUserInfoByDisplayNameOptions, completionDelegate: (UserInfoQueryUserInfoByDisplayNameCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = UserInfoQueryUserInfoByDisplayNameCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_UserInfo_QueryUserInfoByDisplayName", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun queryUserInfoByExternalAccount(options: UserInfoQueryUserInfoByExternalAccountOptions, completionDelegate: (UserInfoQueryUserInfoByExternalAccountCallbackInfo) -> Unit) {
    var stubId = 0L
    val stub = CallbackStubs.register { data -> val info = UserInfoQueryUserInfoByExternalAccountCallbackInfo(data.address()); completionDelegate(info) }
    stubId = stub.id
    Native.invokeVoid("EOS_UserInfo_QueryUserInfoByExternalAccount", listOf(handle, options.address, 0L, stub.segment.address()), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS))
  }

  public fun copyUserInfo(options: UserInfoCopyUserInfoOptions): UserInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_UserInfo_CopyUserInfo", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    UserInfo(RawMemory.getLong(out))
  }

  public fun getExternalUserInfoCount(options: UserInfoGetExternalUserInfoCountOptions): Int = (Native.invoke("EOS_UserInfo_GetExternalUserInfoCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun copyExternalUserInfoByIndex(options: UserInfoCopyExternalUserInfoByIndexOptions): UserInfoExternalUserInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_UserInfo_CopyExternalUserInfoByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    UserInfoExternalUserInfo(RawMemory.getLong(out))
  }

  public fun copyExternalUserInfoByAccountType(options: UserInfoCopyExternalUserInfoByAccountTypeOptions): UserInfoExternalUserInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_UserInfo_CopyExternalUserInfoByAccountType", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    UserInfoExternalUserInfo(RawMemory.getLong(out))
  }

  public fun copyExternalUserInfoByAccountId(options: UserInfoCopyExternalUserInfoByAccountIdOptions): UserInfoExternalUserInfo = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_UserInfo_CopyExternalUserInfoByAccountId", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    UserInfoExternalUserInfo(RawMemory.getLong(out))
  }

  public fun copyBestDisplayName(options: UserInfoCopyBestDisplayNameOptions): UserInfoBestDisplayName = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_UserInfo_CopyBestDisplayName", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    UserInfoBestDisplayName(RawMemory.getLong(out))
  }

  public fun copyBestDisplayNameWithPlatform(options: UserInfoCopyBestDisplayNameWithPlatformOptions): UserInfoBestDisplayName = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_UserInfo_CopyBestDisplayNameWithPlatform", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    UserInfoBestDisplayName(RawMemory.getLong(out))
  }

  public fun getLocalPlatformType(options: UserInfoGetLocalPlatformTypeOptions): Int = (Native.invoke("EOS_UserInfo_GetLocalPlatformType", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public companion object {
    public val NULL: HUserInfo = HUserInfo(0)
  }
}

public object EosSdk {
  public fun achievementsDefinitionV2Release(achievementDefinition: AchievementsDefinitionV2) {
    Native.invokeVoid("EOS_Achievements_DefinitionV2_Release", listOf(achievementDefinition.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun achievementsPlayerAchievementRelease(achievement: AchievementsPlayerAchievement) {
    Native.invokeVoid("EOS_Achievements_PlayerAchievement_Release", listOf(achievement.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun achievementsDefinitionRelease(achievementDefinition: AchievementsDefinition) {
    Native.invokeVoid("EOS_Achievements_Definition_Release", listOf(achievementDefinition.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun achievementsUnlockedAchievementRelease(achievement: AchievementsUnlockedAchievement) {
    Native.invokeVoid("EOS_Achievements_UnlockedAchievement_Release", listOf(achievement.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun authTokenRelease(authToken: AuthToken) {
    Native.invokeVoid("EOS_Auth_Token_Release", listOf(authToken.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun authIdTokenRelease(idToken: AuthIdToken) {
    Native.invokeVoid("EOS_Auth_IdToken_Release", listOf(idToken.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun eResultToString(result: EosResult): String? = (Native.invoke("EOS_EResult_ToString", listOf(result.value), listOf(ValueLayout.JAVA_INT), ValueLayout.JAVA_LONG) as Long).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }

  public fun eResultIsOperationComplete(result: EosResult): Boolean = (Native.invoke("EOS_EResult_IsOperationComplete", listOf(result.value), listOf(ValueLayout.JAVA_INT), ValueLayout.JAVA_INT) as Int) != 0

  public fun byteArrayToString(byteArray: Long, length: Int): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_ByteArray_ToString", listOf(byteArray, length, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun epicAccountIdIsValid(accountId: EpicAccountId): Boolean = (Native.invoke("EOS_EpicAccountId_IsValid", listOf(accountId.raw), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int) != 0

  public fun epicAccountIdToString(accountId: EpicAccountId): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_EpicAccountId_ToString", listOf(accountId.raw, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun epicAccountIdFromString(accountIdString: String?): EpicAccountId = Arena.ofConfined().use { arena ->
    EpicAccountId(Native.invoke("EOS_EpicAccountId_FromString", listOf(if (accountIdString == null) 0L else arena.allocateFrom(accountIdString).address()), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)
  }

  public fun productUserIdIsValid(accountId: ProductUserId): Boolean = (Native.invoke("EOS_ProductUserId_IsValid", listOf(accountId.raw), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int) != 0

  public fun productUserIdToString(accountId: ProductUserId): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_ProductUserId_ToString", listOf(accountId.raw, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun productUserIdFromString(productUserIdString: String?): ProductUserId = Arena.ofConfined().use { arena ->
    ProductUserId(Native.invoke("EOS_ProductUserId_FromString", listOf(if (productUserIdString == null) 0L else arena.allocateFrom(productUserIdString).address()), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)
  }

  public fun continuanceTokenToString(continuanceToken: ContinuanceToken): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_ContinuanceToken_ToString", listOf(continuanceToken.raw, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun connectExternalAccountInfoRelease(externalAccountInfo: ConnectExternalAccountInfo) {
    Native.invokeVoid("EOS_Connect_ExternalAccountInfo_Release", listOf(externalAccountInfo.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun connectIdTokenRelease(idToken: ConnectIdToken) {
    Native.invokeVoid("EOS_Connect_IdToken_Release", listOf(idToken.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun ecomTransactionGetTransactionId(handle: Long): String = Arena.ofConfined().use { arena ->
    var size = 256
    var text: Long
    var result: EosResult
    do {
      text = arena.allocate(size.toLong()).address()
      val length = arena.allocate(4).address()
      RawMemory.putInt(length, size)
      result = EosResult.fromValue(Native.invoke("EOS_Ecom_Transaction_GetTransactionId", listOf(handle, text, length), listOf(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
      val retry = result == EosResult.LimitExceeded && RawMemory.getInt(length) > size
      if (retry) size = RawMemory.getInt(length)
    }
    while (retry)
    if (result != EosResult.Success) throw EosException(result)
    MemorySegment.ofAddress(text).reinterpret(size.toLong()).getString(0)
  }

  public fun ecomTransactionGetEntitlementsCount(handle: Long, options: EcomTransactionGetEntitlementsCountOptions): Int = (Native.invoke("EOS_Ecom_Transaction_GetEntitlementsCount", listOf(handle, options.address), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun ecomTransactionCopyEntitlementByIndex(handle: Long, options: EcomTransactionCopyEntitlementByIndexOptions): EcomEntitlement = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_Ecom_Transaction_CopyEntitlementByIndex", listOf(handle, options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    EcomEntitlement(RawMemory.getLong(out))
  }

  public fun ecomEntitlementRelease(entitlement: EcomEntitlement) {
    Native.invokeVoid("EOS_Ecom_Entitlement_Release", listOf(entitlement.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun ecomCatalogItemRelease(catalogItem: EcomCatalogItem) {
    Native.invokeVoid("EOS_Ecom_CatalogItem_Release", listOf(catalogItem.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun ecomCatalogOfferRelease(catalogOffer: EcomCatalogOffer) {
    Native.invokeVoid("EOS_Ecom_CatalogOffer_Release", listOf(catalogOffer.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun ecomKeyImageInfoRelease(keyImageInfo: EcomKeyImageInfo) {
    Native.invokeVoid("EOS_Ecom_KeyImageInfo_Release", listOf(keyImageInfo.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun ecomCatalogReleaseRelease(catalogRelease: EcomCatalogRelease) {
    Native.invokeVoid("EOS_Ecom_CatalogRelease_Release", listOf(catalogRelease.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun ecomTransactionRelease(transaction: Long) {
    Native.invokeVoid("EOS_Ecom_Transaction_Release", listOf(transaction), listOf(ValueLayout.JAVA_LONG))
  }

  public fun initialize(options: InitializeOptions): EosResult = EosResult.fromValue(Native.invoke("EOS_Initialize", listOf(options.address), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun shutdown(): EosResult = EosResult.fromValue(Native.invoke("EOS_Shutdown", listOf(), listOf(), ValueLayout.JAVA_INT) as Int)

  public fun platformCreate(options: PlatformOptions): HPlatform = HPlatform(Native.invoke("EOS_Platform_Create", listOf(options.address), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_LONG) as Long)

  public fun integratedPlatformCreateIntegratedPlatformOptionsContainer(options: IntegratedPlatformCreateIntegratedPlatformOptionsContainerOptions): HIntegratedPlatformOptionsContainer = Arena.ofConfined().use { arena ->
    val out = arena.allocate(8).address()
    val result = EosResult.fromValue(Native.invoke("EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainer", listOf(options.address, out), listOf(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), ValueLayout.JAVA_INT) as Int)
    if (result != EosResult.Success) throw EosException(result)
    HIntegratedPlatformOptionsContainer(RawMemory.getLong(out))
  }

  public fun kWSPermissionStatusRelease(permissionStatus: KWSPermissionStatus) {
    Native.invokeVoid("EOS_KWS_PermissionStatus_Release", listOf(permissionStatus.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun leaderboardsDefinitionRelease(leaderboardDefinition: LeaderboardsDefinition) {
    Native.invokeVoid("EOS_Leaderboards_Definition_Release", listOf(leaderboardDefinition.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun leaderboardsLeaderboardUserScoreRelease(leaderboardUserScore: LeaderboardsLeaderboardUserScore) {
    Native.invokeVoid("EOS_Leaderboards_LeaderboardUserScore_Release", listOf(leaderboardUserScore.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun leaderboardsLeaderboardRecordRelease(leaderboardRecord: LeaderboardsLeaderboardRecord) {
    Native.invokeVoid("EOS_Leaderboards_LeaderboardRecord_Release", listOf(leaderboardRecord.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun leaderboardsLeaderboardDefinitionRelease(leaderboardDefinition: LeaderboardsDefinition) {
    Native.invokeVoid("EOS_Leaderboards_LeaderboardDefinition_Release", listOf(leaderboardDefinition.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun lobbyDetailsInfoRelease(lobbyDetailsInfo: LobbyDetailsInfo) {
    Native.invokeVoid("EOS_LobbyDetails_Info_Release", listOf(lobbyDetailsInfo.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun lobbyAttributeRelease(lobbyAttribute: LobbyAttribute) {
    Native.invokeVoid("EOS_Lobby_Attribute_Release", listOf(lobbyAttribute.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun lobbyDetailsMemberInfoRelease(lobbyDetailsMemberInfo: LobbyDetailsMemberInfo) {
    Native.invokeVoid("EOS_LobbyDetails_MemberInfo_Release", listOf(lobbyDetailsMemberInfo.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun loggingSetCallback(callback: Long): EosResult = EosResult.fromValue(Native.invoke("EOS_Logging_SetCallback", listOf(callback), listOf(ValueLayout.JAVA_LONG), ValueLayout.JAVA_INT) as Int)

  public fun loggingSetLogLevel(logCategory: Int, logLevel: ELogLevel): EosResult = EosResult.fromValue(Native.invoke("EOS_Logging_SetLogLevel", listOf(logCategory, logLevel.value), listOf(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT), ValueLayout.JAVA_INT) as Int)

  public fun modsModInfoRelease(modInfo: ModsModInfo) {
    Native.invokeVoid("EOS_Mods_ModInfo_Release", listOf(modInfo.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun playerDataStorageFileMetadataRelease(fileMetadata: PlayerDataStorageFileMetadata) {
    Native.invokeVoid("EOS_PlayerDataStorage_FileMetadata_Release", listOf(fileMetadata.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun presenceInfoRelease(presenceInfo: PresenceInfo) {
    Native.invokeVoid("EOS_Presence_Info_Release", listOf(presenceInfo.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun rTCAdminUserTokenRelease(userToken: RTCAdminUserToken) {
    Native.invokeVoid("EOS_RTCAdmin_UserToken_Release", listOf(userToken.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun rTCAudioInputDeviceInformationRelease(deviceInformation: RTCAudioInputDeviceInformation) {
    Native.invokeVoid("EOS_RTCAudio_InputDeviceInformation_Release", listOf(deviceInformation.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun rTCAudioOutputDeviceInformationRelease(deviceInformation: RTCAudioOutputDeviceInformation) {
    Native.invokeVoid("EOS_RTCAudio_OutputDeviceInformation_Release", listOf(deviceInformation.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun sanctionsPlayerSanctionRelease(sanction: SanctionsPlayerSanction) {
    Native.invokeVoid("EOS_Sanctions_PlayerSanction_Release", listOf(sanction.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun sessionDetailsAttributeRelease(sessionAttribute: SessionDetailsAttribute) {
    Native.invokeVoid("EOS_SessionDetails_Attribute_Release", listOf(sessionAttribute.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun sessionDetailsInfoRelease(sessionInfo: SessionDetailsInfo) {
    Native.invokeVoid("EOS_SessionDetails_Info_Release", listOf(sessionInfo.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun activeSessionInfoRelease(activeSessionInfo: ActiveSessionInfo) {
    Native.invokeVoid("EOS_ActiveSession_Info_Release", listOf(activeSessionInfo.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun statsStatRelease(stat: StatsStat) {
    Native.invokeVoid("EOS_Stats_Stat_Release", listOf(stat.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun titleStorageFileMetadataRelease(fileMetadata: TitleStorageFileMetadata) {
    Native.invokeVoid("EOS_TitleStorage_FileMetadata_Release", listOf(fileMetadata.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun eApplicationStatusToString(applicationStatus: EApplicationStatus): String? = (Native.invoke("EOS_EApplicationStatus_ToString", listOf(applicationStatus.value), listOf(ValueLayout.JAVA_INT), ValueLayout.JAVA_LONG) as Long).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }

  public fun eNetworkStatusToString(networkStatus: ENetworkStatus): String? = (Native.invoke("EOS_ENetworkStatus_ToString", listOf(networkStatus.value), listOf(ValueLayout.JAVA_INT), ValueLayout.JAVA_LONG) as Long).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }

  public fun userInfoRelease(userInfo: UserInfo) {
    Native.invokeVoid("EOS_UserInfo_Release", listOf(userInfo.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun userInfoExternalUserInfoRelease(externalUserInfo: UserInfoExternalUserInfo) {
    Native.invokeVoid("EOS_UserInfo_ExternalUserInfo_Release", listOf(externalUserInfo.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun userInfoBestDisplayNameRelease(bestDisplayName: UserInfoBestDisplayName) {
    Native.invokeVoid("EOS_UserInfo_BestDisplayName_Release", listOf(bestDisplayName.address), listOf(ValueLayout.JAVA_LONG))
  }

  public fun getVersion(): String? = (Native.invoke("EOS_GetVersion", listOf(), listOf(), ValueLayout.JAVA_LONG) as Long).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
}
