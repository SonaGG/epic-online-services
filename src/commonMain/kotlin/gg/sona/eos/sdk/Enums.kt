@file:Suppress("unused", "FunctionName", "PropertyName")

package gg.sona.eos.sdk

import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.jvm.JvmInline

@JvmInline
public value class EAntiCheatClientMode(
  public val `value`: Int,
) {
  public companion object {
    public val Invalid: EAntiCheatClientMode = EAntiCheatClientMode(0)

    public val ClientServer: EAntiCheatClientMode = EAntiCheatClientMode(1)

    public val PeerToPeer: EAntiCheatClientMode = EAntiCheatClientMode(2)
  }
}

@JvmInline
public value class EAntiCheatClientViolationType(
  public val `value`: Int,
) {
  public companion object {
    public val Invalid: EAntiCheatClientViolationType = EAntiCheatClientViolationType(0)

    public val IntegrityCatalogNotFound: EAntiCheatClientViolationType =
        EAntiCheatClientViolationType(1)

    public val IntegrityCatalogError: EAntiCheatClientViolationType =
        EAntiCheatClientViolationType(2)

    public val IntegrityCatalogCertificateRevoked: EAntiCheatClientViolationType =
        EAntiCheatClientViolationType(3)

    public val IntegrityCatalogMissingMainExecutable: EAntiCheatClientViolationType =
        EAntiCheatClientViolationType(4)

    public val GameFileMismatch: EAntiCheatClientViolationType = EAntiCheatClientViolationType(5)

    public val RequiredGameFileNotFound: EAntiCheatClientViolationType =
        EAntiCheatClientViolationType(6)

    public val UnknownGameFileForbidden: EAntiCheatClientViolationType =
        EAntiCheatClientViolationType(7)

    public val SystemFileUntrusted: EAntiCheatClientViolationType = EAntiCheatClientViolationType(8)

    public val ForbiddenModuleLoaded: EAntiCheatClientViolationType =
        EAntiCheatClientViolationType(9)

    public val CorruptedMemory: EAntiCheatClientViolationType = EAntiCheatClientViolationType(10)

    public val ForbiddenToolDetected: EAntiCheatClientViolationType =
        EAntiCheatClientViolationType(11)

    public val InternalAntiCheatViolation: EAntiCheatClientViolationType =
        EAntiCheatClientViolationType(12)

    public val CorruptedNetworkMessageFlow: EAntiCheatClientViolationType =
        EAntiCheatClientViolationType(13)

    public val VirtualMachineNotAllowed: EAntiCheatClientViolationType =
        EAntiCheatClientViolationType(14)

    public val ForbiddenSystemConfiguration: EAntiCheatClientViolationType =
        EAntiCheatClientViolationType(15)
  }
}

@JvmInline
public value class EAntiCheatCommonClientType(
  public val `value`: Int,
) {
  public companion object {
    public val ProtectedClient: EAntiCheatCommonClientType = EAntiCheatCommonClientType(0)

    public val UnprotectedClient: EAntiCheatCommonClientType = EAntiCheatCommonClientType(1)

    public val AIBot: EAntiCheatCommonClientType = EAntiCheatCommonClientType(2)
  }
}

@JvmInline
public value class EAntiCheatCommonClientPlatform(
  public val `value`: Int,
) {
  public companion object {
    public val Unknown: EAntiCheatCommonClientPlatform = EAntiCheatCommonClientPlatform(0)

    public val Windows: EAntiCheatCommonClientPlatform = EAntiCheatCommonClientPlatform(1)

    public val Mac: EAntiCheatCommonClientPlatform = EAntiCheatCommonClientPlatform(2)

    public val Linux: EAntiCheatCommonClientPlatform = EAntiCheatCommonClientPlatform(3)

    public val Xbox: EAntiCheatCommonClientPlatform = EAntiCheatCommonClientPlatform(4)

    public val PlayStation: EAntiCheatCommonClientPlatform = EAntiCheatCommonClientPlatform(5)

    public val Nintendo: EAntiCheatCommonClientPlatform = EAntiCheatCommonClientPlatform(6)

    public val iOS: EAntiCheatCommonClientPlatform = EAntiCheatCommonClientPlatform(7)

    public val Android: EAntiCheatCommonClientPlatform = EAntiCheatCommonClientPlatform(8)
  }
}

@JvmInline
public value class EAntiCheatCommonClientAction(
  public val `value`: Int,
) {
  public companion object {
    public val Invalid: EAntiCheatCommonClientAction = EAntiCheatCommonClientAction(0)

    public val RemovePlayer: EAntiCheatCommonClientAction = EAntiCheatCommonClientAction(1)
  }
}

@JvmInline
public value class EAntiCheatCommonClientActionReason(
  public val `value`: Int,
) {
  public companion object {
    public val Invalid: EAntiCheatCommonClientActionReason = EAntiCheatCommonClientActionReason(0)

    public val InternalError: EAntiCheatCommonClientActionReason =
        EAntiCheatCommonClientActionReason(1)

    public val InvalidMessage: EAntiCheatCommonClientActionReason =
        EAntiCheatCommonClientActionReason(2)

    public val AuthenticationFailed: EAntiCheatCommonClientActionReason =
        EAntiCheatCommonClientActionReason(3)

    public val NullClient: EAntiCheatCommonClientActionReason =
        EAntiCheatCommonClientActionReason(4)

    public val HeartbeatTimeout: EAntiCheatCommonClientActionReason =
        EAntiCheatCommonClientActionReason(5)

    public val ClientViolation: EAntiCheatCommonClientActionReason =
        EAntiCheatCommonClientActionReason(6)

    public val BackendViolation: EAntiCheatCommonClientActionReason =
        EAntiCheatCommonClientActionReason(7)

    public val TemporaryCooldown: EAntiCheatCommonClientActionReason =
        EAntiCheatCommonClientActionReason(8)

    public val TemporaryBanned: EAntiCheatCommonClientActionReason =
        EAntiCheatCommonClientActionReason(9)

    public val PermanentBanned: EAntiCheatCommonClientActionReason =
        EAntiCheatCommonClientActionReason(10)
  }
}

@JvmInline
public value class EAntiCheatCommonClientAuthStatus(
  public val `value`: Int,
) {
  public companion object {
    public val Invalid: EAntiCheatCommonClientAuthStatus = EAntiCheatCommonClientAuthStatus(0)

    public val LocalAuthComplete: EAntiCheatCommonClientAuthStatus =
        EAntiCheatCommonClientAuthStatus(1)

    public val RemoteAuthComplete: EAntiCheatCommonClientAuthStatus =
        EAntiCheatCommonClientAuthStatus(2)
  }
}

@JvmInline
public value class EAntiCheatCommonClientFlags(
  public val `value`: Int,
) {
  public infix fun or(other: EAntiCheatCommonClientFlags): EAntiCheatCommonClientFlags = EAntiCheatCommonClientFlags(value or other.value)

  public infix fun and(other: EAntiCheatCommonClientFlags): EAntiCheatCommonClientFlags = EAntiCheatCommonClientFlags(value and other.value)

  public operator fun contains(other: EAntiCheatCommonClientFlags): Boolean = value and other.value == other.value

  public companion object {
    public val None: EAntiCheatCommonClientFlags = EAntiCheatCommonClientFlags(0)

    public val Admin: EAntiCheatCommonClientFlags = EAntiCheatCommonClientFlags(1)
  }
}

@JvmInline
public value class EAntiCheatCommonClientInput(
  public val `value`: Int,
) {
  public companion object {
    public val Unknown: EAntiCheatCommonClientInput = EAntiCheatCommonClientInput(0)

    public val MouseKeyboard: EAntiCheatCommonClientInput = EAntiCheatCommonClientInput(1)

    public val Gamepad: EAntiCheatCommonClientInput = EAntiCheatCommonClientInput(2)

    public val TouchInput: EAntiCheatCommonClientInput = EAntiCheatCommonClientInput(3)
  }
}

@JvmInline
public value class EAntiCheatCommonEventType(
  public val `value`: Int,
) {
  public companion object {
    public val Invalid: EAntiCheatCommonEventType = EAntiCheatCommonEventType(0)

    public val GameEvent: EAntiCheatCommonEventType = EAntiCheatCommonEventType(1)

    public val PlayerEvent: EAntiCheatCommonEventType = EAntiCheatCommonEventType(2)
  }
}

@JvmInline
public value class EAntiCheatCommonEventParamType(
  public val `value`: Int,
) {
  public companion object {
    public val Invalid: EAntiCheatCommonEventParamType = EAntiCheatCommonEventParamType(0)

    public val ClientHandle: EAntiCheatCommonEventParamType = EAntiCheatCommonEventParamType(1)

    public val String: EAntiCheatCommonEventParamType = EAntiCheatCommonEventParamType(2)

    public val UInt32: EAntiCheatCommonEventParamType = EAntiCheatCommonEventParamType(3)

    public val Int32: EAntiCheatCommonEventParamType = EAntiCheatCommonEventParamType(4)

    public val UInt64: EAntiCheatCommonEventParamType = EAntiCheatCommonEventParamType(5)

    public val Int64: EAntiCheatCommonEventParamType = EAntiCheatCommonEventParamType(6)

    public val Vector3f: EAntiCheatCommonEventParamType = EAntiCheatCommonEventParamType(7)

    public val Quat: EAntiCheatCommonEventParamType = EAntiCheatCommonEventParamType(8)

    public val Float: EAntiCheatCommonEventParamType = EAntiCheatCommonEventParamType(9)
  }
}

@JvmInline
public value class EAntiCheatCommonGameRoundCompetitionType(
  public val `value`: Int,
) {
  public companion object {
    public val None: EAntiCheatCommonGameRoundCompetitionType =
        EAntiCheatCommonGameRoundCompetitionType(0)

    public val Casual: EAntiCheatCommonGameRoundCompetitionType =
        EAntiCheatCommonGameRoundCompetitionType(1)

    public val Ranked: EAntiCheatCommonGameRoundCompetitionType =
        EAntiCheatCommonGameRoundCompetitionType(2)

    public val Competitive: EAntiCheatCommonGameRoundCompetitionType =
        EAntiCheatCommonGameRoundCompetitionType(3)
  }
}

@JvmInline
public value class EAntiCheatCommonPlayerMovementState(
  public val `value`: Int,
) {
  public companion object {
    public val None: EAntiCheatCommonPlayerMovementState = EAntiCheatCommonPlayerMovementState(0)

    public val Crouching: EAntiCheatCommonPlayerMovementState =
        EAntiCheatCommonPlayerMovementState(1)

    public val Prone: EAntiCheatCommonPlayerMovementState = EAntiCheatCommonPlayerMovementState(2)

    public val Mounted: EAntiCheatCommonPlayerMovementState = EAntiCheatCommonPlayerMovementState(3)

    public val Swimming: EAntiCheatCommonPlayerMovementState =
        EAntiCheatCommonPlayerMovementState(4)

    public val Falling: EAntiCheatCommonPlayerMovementState = EAntiCheatCommonPlayerMovementState(5)

    public val Flying: EAntiCheatCommonPlayerMovementState = EAntiCheatCommonPlayerMovementState(6)

    public val OnLadder: EAntiCheatCommonPlayerMovementState =
        EAntiCheatCommonPlayerMovementState(7)
  }
}

@JvmInline
public value class EAntiCheatCommonPlayerTakeDamageSource(
  public val `value`: Int,
) {
  public companion object {
    public val None: EAntiCheatCommonPlayerTakeDamageSource =
        EAntiCheatCommonPlayerTakeDamageSource(0)

    public val Player: EAntiCheatCommonPlayerTakeDamageSource =
        EAntiCheatCommonPlayerTakeDamageSource(1)

    public val NonPlayerCharacter: EAntiCheatCommonPlayerTakeDamageSource =
        EAntiCheatCommonPlayerTakeDamageSource(2)

    public val World: EAntiCheatCommonPlayerTakeDamageSource =
        EAntiCheatCommonPlayerTakeDamageSource(3)
  }
}

@JvmInline
public value class EAntiCheatCommonPlayerTakeDamageType(
  public val `value`: Int,
) {
  public companion object {
    public val None: EAntiCheatCommonPlayerTakeDamageType = EAntiCheatCommonPlayerTakeDamageType(0)

    public val PointDamage: EAntiCheatCommonPlayerTakeDamageType =
        EAntiCheatCommonPlayerTakeDamageType(1)

    public val RadialDamage: EAntiCheatCommonPlayerTakeDamageType =
        EAntiCheatCommonPlayerTakeDamageType(2)

    public val DamageOverTime: EAntiCheatCommonPlayerTakeDamageType =
        EAntiCheatCommonPlayerTakeDamageType(3)
  }
}

@JvmInline
public value class EAntiCheatCommonPlayerTakeDamageResult(
  public val `value`: Int,
) {
  public companion object {
    public val None: EAntiCheatCommonPlayerTakeDamageResult =
        EAntiCheatCommonPlayerTakeDamageResult(0)

    public val DownedDEPRECATED: EAntiCheatCommonPlayerTakeDamageResult =
        EAntiCheatCommonPlayerTakeDamageResult(1)

    public val EliminatedDEPRECATED: EAntiCheatCommonPlayerTakeDamageResult =
        EAntiCheatCommonPlayerTakeDamageResult(2)

    public val NormalToDowned: EAntiCheatCommonPlayerTakeDamageResult =
        EAntiCheatCommonPlayerTakeDamageResult(3)

    public val NormalToEliminated: EAntiCheatCommonPlayerTakeDamageResult =
        EAntiCheatCommonPlayerTakeDamageResult(4)

    public val DownedToEliminated: EAntiCheatCommonPlayerTakeDamageResult =
        EAntiCheatCommonPlayerTakeDamageResult(5)
  }
}

@JvmInline
public value class EAntiCheatCommonClientSystemConfig(
  public val `value`: Int,
) {
  public infix fun or(other: EAntiCheatCommonClientSystemConfig): EAntiCheatCommonClientSystemConfig = EAntiCheatCommonClientSystemConfig(value or other.value)

  public infix fun and(other: EAntiCheatCommonClientSystemConfig): EAntiCheatCommonClientSystemConfig = EAntiCheatCommonClientSystemConfig(value and other.value)

  public operator fun contains(other: EAntiCheatCommonClientSystemConfig): Boolean = value and other.value == other.value

  public companion object {
    public val None: EAntiCheatCommonClientSystemConfig = EAntiCheatCommonClientSystemConfig(0)

    public val CryptoProcessor: EAntiCheatCommonClientSystemConfig =
        EAntiCheatCommonClientSystemConfig(1)

    public val SecureBoot: EAntiCheatCommonClientSystemConfig =
        EAntiCheatCommonClientSystemConfig(2)

    public val KernelCodeIntegrity: EAntiCheatCommonClientSystemConfig =
        EAntiCheatCommonClientSystemConfig(4)

    public val IOMMU: EAntiCheatCommonClientSystemConfig = EAntiCheatCommonClientSystemConfig(8)

    public val StableOSVersion: EAntiCheatCommonClientSystemConfig =
        EAntiCheatCommonClientSystemConfig(16)

    public val StrictInjectionPolicy: EAntiCheatCommonClientSystemConfig =
        EAntiCheatCommonClientSystemConfig(32)

    public val SecureFirmware: EAntiCheatCommonClientSystemConfig =
        EAntiCheatCommonClientSystemConfig(64)

    public val DmaRemapping: EAntiCheatCommonClientSystemConfig =
        EAntiCheatCommonClientSystemConfig(128)

    public val NoOutdatedOS: EAntiCheatCommonClientSystemConfig =
        EAntiCheatCommonClientSystemConfig(256)
  }
}

@JvmInline
public value class EAntiCheatClientSystemRequirementStatus(
  public val `value`: Int,
) {
  public companion object {
    public val NotMet: EAntiCheatClientSystemRequirementStatus =
        EAntiCheatClientSystemRequirementStatus(0)

    public val MetWithWarning: EAntiCheatClientSystemRequirementStatus =
        EAntiCheatClientSystemRequirementStatus(1)

    public val FullyMet: EAntiCheatClientSystemRequirementStatus =
        EAntiCheatClientSystemRequirementStatus(2)
  }
}

@JvmInline
public value class ELoginCredentialType(
  public val `value`: Int,
) {
  public companion object {
    public val Password: ELoginCredentialType = ELoginCredentialType(0)

    public val ExchangeCode: ELoginCredentialType = ELoginCredentialType(1)

    public val PersistentAuth: ELoginCredentialType = ELoginCredentialType(2)

    public val DeviceCode: ELoginCredentialType = ELoginCredentialType(3)

    public val Developer: ELoginCredentialType = ELoginCredentialType(4)

    public val RefreshToken: ELoginCredentialType = ELoginCredentialType(5)

    public val AccountPortal: ELoginCredentialType = ELoginCredentialType(6)

    public val ExternalAuth: ELoginCredentialType = ELoginCredentialType(7)
  }
}

@JvmInline
public value class EAuthTokenType(
  public val `value`: Int,
) {
  public companion object {
    public val Client: EAuthTokenType = EAuthTokenType(0)

    public val User: EAuthTokenType = EAuthTokenType(1)
  }
}

@JvmInline
public value class EAuthScopeFlags(
  public val `value`: Int,
) {
  public infix fun or(other: EAuthScopeFlags): EAuthScopeFlags = EAuthScopeFlags(value or other.value)

  public infix fun and(other: EAuthScopeFlags): EAuthScopeFlags = EAuthScopeFlags(value and other.value)

  public operator fun contains(other: EAuthScopeFlags): Boolean = value and other.value == other.value

  public companion object {
    public val NoFlags: EAuthScopeFlags = EAuthScopeFlags(0)

    public val BasicProfile: EAuthScopeFlags = EAuthScopeFlags(1)

    public val FriendsList: EAuthScopeFlags = EAuthScopeFlags(2)

    public val Presence: EAuthScopeFlags = EAuthScopeFlags(4)

    public val FriendsManagement: EAuthScopeFlags = EAuthScopeFlags(8)

    public val Email: EAuthScopeFlags = EAuthScopeFlags(16)

    public val Country: EAuthScopeFlags = EAuthScopeFlags(32)
  }
}

@JvmInline
public value class ELinkAccountFlags(
  public val `value`: Int,
) {
  public companion object {
    public val NoFlags: ELinkAccountFlags = ELinkAccountFlags(0)

    public val NintendoNsaId: ELinkAccountFlags = ELinkAccountFlags(1)
  }
}

@JvmInline
public value class ELoginStatus(
  public val `value`: Int,
) {
  public companion object {
    public val NotLoggedIn: ELoginStatus = ELoginStatus(0)

    public val UsingLocalProfile: ELoginStatus = ELoginStatus(1)

    public val LoggedIn: ELoginStatus = ELoginStatus(2)
  }
}

@JvmInline
public value class EAttributeType(
  public val `value`: Int,
) {
  public companion object {
    public val BOOLEAN: EAttributeType = EAttributeType(0)

    public val INT64: EAttributeType = EAttributeType(1)

    public val DOUBLE: EAttributeType = EAttributeType(2)

    public val STRING: EAttributeType = EAttributeType(3)
  }
}

@JvmInline
public value class EComparisonOp(
  public val `value`: Int,
) {
  public companion object {
    public val EQUAL: EComparisonOp = EComparisonOp(0)

    public val NOTEQUAL: EComparisonOp = EComparisonOp(1)

    public val GREATERTHAN: EComparisonOp = EComparisonOp(2)

    public val GREATERTHANOREQUAL: EComparisonOp = EComparisonOp(3)

    public val LESSTHAN: EComparisonOp = EComparisonOp(4)

    public val LESSTHANOREQUAL: EComparisonOp = EComparisonOp(5)

    public val DISTANCE: EComparisonOp = EComparisonOp(6)

    public val ANYOF: EComparisonOp = EComparisonOp(7)

    public val NOTANYOF: EComparisonOp = EComparisonOp(8)

    public val ONEOF: EComparisonOp = EComparisonOp(9)

    public val NOTONEOF: EComparisonOp = EComparisonOp(10)

    public val CONTAINS: EComparisonOp = EComparisonOp(11)

    public val REGEXMATCH: EComparisonOp = EComparisonOp(12)

    public val SIZE: EComparisonOp = EComparisonOp(13)
  }
}

@JvmInline
public value class EExternalAccountType(
  public val `value`: Int,
) {
  public companion object {
    public val EPIC: EExternalAccountType = EExternalAccountType(0)

    public val STEAM: EExternalAccountType = EExternalAccountType(1)

    public val PSN: EExternalAccountType = EExternalAccountType(2)

    public val XBL: EExternalAccountType = EExternalAccountType(3)

    public val DISCORD: EExternalAccountType = EExternalAccountType(4)

    public val GOG: EExternalAccountType = EExternalAccountType(5)

    public val NINTENDO: EExternalAccountType = EExternalAccountType(6)

    public val UPLAY: EExternalAccountType = EExternalAccountType(7)

    public val OPENID: EExternalAccountType = EExternalAccountType(8)

    public val APPLE: EExternalAccountType = EExternalAccountType(9)

    public val GOOGLE: EExternalAccountType = EExternalAccountType(10)

    public val OCULUS: EExternalAccountType = EExternalAccountType(11)

    public val ITCHIO: EExternalAccountType = EExternalAccountType(12)

    public val AMAZON: EExternalAccountType = EExternalAccountType(13)

    public val VIVEPORT: EExternalAccountType = EExternalAccountType(14)
  }
}

@JvmInline
public value class EExternalCredentialType(
  public val `value`: Int,
) {
  public companion object {
    public val EPIC: EExternalCredentialType = EExternalCredentialType(0)

    public val STEAMAPPTICKET: EExternalCredentialType = EExternalCredentialType(1)

    public val PSNIDTOKEN: EExternalCredentialType = EExternalCredentialType(2)

    public val XBLXSTSTOKEN: EExternalCredentialType = EExternalCredentialType(3)

    public val DISCORDACCESSTOKEN: EExternalCredentialType = EExternalCredentialType(4)

    public val GOGSESSIONTICKET: EExternalCredentialType = EExternalCredentialType(5)

    public val NINTENDOIDTOKEN: EExternalCredentialType = EExternalCredentialType(6)

    public val NINTENDONSAIDTOKEN: EExternalCredentialType = EExternalCredentialType(7)

    public val UPLAYACCESSTOKEN: EExternalCredentialType = EExternalCredentialType(8)

    public val OPENIDACCESSTOKEN: EExternalCredentialType = EExternalCredentialType(9)

    public val DEVICEIDACCESSTOKEN: EExternalCredentialType = EExternalCredentialType(10)

    public val APPLEIDTOKEN: EExternalCredentialType = EExternalCredentialType(11)

    public val GOOGLEIDTOKEN: EExternalCredentialType = EExternalCredentialType(12)

    public val OCULUSUSERIDNONCE: EExternalCredentialType = EExternalCredentialType(13)

    public val ITCHIOJWT: EExternalCredentialType = EExternalCredentialType(14)

    public val ITCHIOKEY: EExternalCredentialType = EExternalCredentialType(15)

    public val EPICIDTOKEN: EExternalCredentialType = EExternalCredentialType(16)

    public val AMAZONACCESSTOKEN: EExternalCredentialType = EExternalCredentialType(17)

    public val STEAMSESSIONTICKET: EExternalCredentialType = EExternalCredentialType(18)

    public val VIVEPORTUSERTOKEN: EExternalCredentialType = EExternalCredentialType(19)
  }
}

@JvmInline
public value class ERequestToJoinResponse(
  public val `value`: Int,
) {
  public companion object {
    public val ACCEPTED: ERequestToJoinResponse = ERequestToJoinResponse(0)

    public val REJECTED: ERequestToJoinResponse = ERequestToJoinResponse(1)
  }
}

@JvmInline
public value class EOwnershipStatus(
  public val `value`: Int,
) {
  public companion object {
    public val NotOwned: EOwnershipStatus = EOwnershipStatus(0)

    public val Owned: EOwnershipStatus = EOwnershipStatus(1)
  }
}

@JvmInline
public value class EEcomItemType(
  public val `value`: Int,
) {
  public companion object {
    public val Durable: EEcomItemType = EEcomItemType(0)

    public val Consumable: EEcomItemType = EEcomItemType(1)

    public val Other: EEcomItemType = EEcomItemType(2)
  }
}

@JvmInline
public value class ECheckoutOrientation(
  public val `value`: Int,
) {
  public companion object {
    public val Default: ECheckoutOrientation = ECheckoutOrientation(0)

    public val Portrait: ECheckoutOrientation = ECheckoutOrientation(1)

    public val Landscape: ECheckoutOrientation = ECheckoutOrientation(2)
  }
}

@JvmInline
public value class ERedeemEntitlementsResultListType(
  public val `value`: Int,
) {
  public companion object {
    public val Redeemed: ERedeemEntitlementsResultListType = ERedeemEntitlementsResultListType(0)

    public val PreviouslyRedeemed: ERedeemEntitlementsResultListType =
        ERedeemEntitlementsResultListType(1)

    public val Invalid: ERedeemEntitlementsResultListType = ERedeemEntitlementsResultListType(2)
  }
}

@JvmInline
public value class EFriendsStatus(
  public val `value`: Int,
) {
  public companion object {
    public val NotFriends: EFriendsStatus = EFriendsStatus(0)

    public val InviteSent: EFriendsStatus = EFriendsStatus(1)

    public val InviteReceived: EFriendsStatus = EFriendsStatus(2)

    public val Friends: EFriendsStatus = EFriendsStatus(3)
  }
}

@JvmInline
public value class EIntegratedPlatformManagementFlags(
  public val `value`: Int,
) {
  public infix fun or(other: EIntegratedPlatformManagementFlags): EIntegratedPlatformManagementFlags = EIntegratedPlatformManagementFlags(value or other.value)

  public infix fun and(other: EIntegratedPlatformManagementFlags): EIntegratedPlatformManagementFlags = EIntegratedPlatformManagementFlags(value and other.value)

  public operator fun contains(other: EIntegratedPlatformManagementFlags): Boolean = value and other.value == other.value

  public companion object {
    public val Disabled: EIntegratedPlatformManagementFlags = EIntegratedPlatformManagementFlags(1)

    public val LibraryManagedByApplication: EIntegratedPlatformManagementFlags =
        EIntegratedPlatformManagementFlags(2)

    public val LibraryManagedBySDK: EIntegratedPlatformManagementFlags =
        EIntegratedPlatformManagementFlags(4)

    public val DisablePresenceMirroring: EIntegratedPlatformManagementFlags =
        EIntegratedPlatformManagementFlags(8)

    public val DisableSDKManagedSessions: EIntegratedPlatformManagementFlags =
        EIntegratedPlatformManagementFlags(16)

    public val PreferEOSIdentity: EIntegratedPlatformManagementFlags =
        EIntegratedPlatformManagementFlags(32)

    public val PreferIntegratedIdentity: EIntegratedPlatformManagementFlags =
        EIntegratedPlatformManagementFlags(64)

    public val ApplicationManagedIdentityLogin: EIntegratedPlatformManagementFlags =
        EIntegratedPlatformManagementFlags(128)
  }
}

@JvmInline
public value class EIntegratedPlatformPreLogoutAction(
  public val `value`: Int,
) {
  public companion object {
    public val ProcessLogoutImmediately: EIntegratedPlatformPreLogoutAction =
        EIntegratedPlatformPreLogoutAction(0)

    public val DeferLogout: EIntegratedPlatformPreLogoutAction =
        EIntegratedPlatformPreLogoutAction(1)
  }
}

@JvmInline
public value class EKWSPermissionStatus(
  public val `value`: Int,
) {
  public companion object {
    public val GRANTED: EKWSPermissionStatus = EKWSPermissionStatus(0)

    public val REJECTED: EKWSPermissionStatus = EKWSPermissionStatus(1)

    public val PENDING: EKWSPermissionStatus = EKWSPermissionStatus(2)
  }
}

@JvmInline
public value class ELeaderboardAggregation(
  public val `value`: Int,
) {
  public companion object {
    public val Min: ELeaderboardAggregation = ELeaderboardAggregation(0)

    public val Max: ELeaderboardAggregation = ELeaderboardAggregation(1)

    public val Sum: ELeaderboardAggregation = ELeaderboardAggregation(2)

    public val Latest: ELeaderboardAggregation = ELeaderboardAggregation(3)
  }
}

@JvmInline
public value class ELobbyPermissionLevel(
  public val `value`: Int,
) {
  public companion object {
    public val PUBLICADVERTISED: ELobbyPermissionLevel = ELobbyPermissionLevel(0)

    public val JOINVIAPRESENCE: ELobbyPermissionLevel = ELobbyPermissionLevel(1)

    public val INVITEONLY: ELobbyPermissionLevel = ELobbyPermissionLevel(2)
  }
}

@JvmInline
public value class ELobbyAttributeVisibility(
  public val `value`: Int,
) {
  public companion object {
    public val PUBLIC: ELobbyAttributeVisibility = ELobbyAttributeVisibility(0)

    public val PRIVATE: ELobbyAttributeVisibility = ELobbyAttributeVisibility(1)
  }
}

@JvmInline
public value class ELobbyMemberStatus(
  public val `value`: Int,
) {
  public companion object {
    public val JOINED: ELobbyMemberStatus = ELobbyMemberStatus(0)

    public val LEFT: ELobbyMemberStatus = ELobbyMemberStatus(1)

    public val DISCONNECTED: ELobbyMemberStatus = ELobbyMemberStatus(2)

    public val KICKED: ELobbyMemberStatus = ELobbyMemberStatus(3)

    public val PROMOTED: ELobbyMemberStatus = ELobbyMemberStatus(4)

    public val CLOSED: ELobbyMemberStatus = ELobbyMemberStatus(5)
  }
}

@JvmInline
public value class ELobbyRTCRoomJoinActionType(
  public val `value`: Int,
) {
  public companion object {
    public val AutomaticJoin: ELobbyRTCRoomJoinActionType = ELobbyRTCRoomJoinActionType(0)

    public val ManualJoin: ELobbyRTCRoomJoinActionType = ELobbyRTCRoomJoinActionType(1)
  }
}

@JvmInline
public value class ELogLevel(
  public val `value`: Int,
) {
  public companion object {
    public val Off: ELogLevel = ELogLevel(0)

    public val Fatal: ELogLevel = ELogLevel(100)

    public val Error: ELogLevel = ELogLevel(200)

    public val Warning: ELogLevel = ELogLevel(300)

    public val Info: ELogLevel = ELogLevel(400)

    public val Verbose: ELogLevel = ELogLevel(500)

    public val VeryVerbose: ELogLevel = ELogLevel(600)
  }
}

@JvmInline
public value class EUserControllerType(
  public val `value`: Int,
) {
  public companion object {
    public val Unknown: EUserControllerType = EUserControllerType(0)

    public val MouseKeyboard: EUserControllerType = EUserControllerType(1)

    public val GamepadControl: EUserControllerType = EUserControllerType(2)

    public val TouchControl: EUserControllerType = EUserControllerType(3)
  }
}

@JvmInline
public value class EMetricsAccountIdType(
  public val `value`: Int,
) {
  public companion object {
    public val Epic: EMetricsAccountIdType = EMetricsAccountIdType(0)

    public val External: EMetricsAccountIdType = EMetricsAccountIdType(1)
  }
}

@JvmInline
public value class EModEnumerationType(
  public val `value`: Int,
) {
  public companion object {
    public val INSTALLED: EModEnumerationType = EModEnumerationType(0)

    public val ALLAVAILABLE: EModEnumerationType = EModEnumerationType(2)
  }
}

@JvmInline
public value class ENATType(
  public val `value`: Int,
) {
  public companion object {
    public val Unknown: ENATType = ENATType(0)

    public val Open: ENATType = ENATType(1)

    public val Moderate: ENATType = ENATType(2)

    public val Strict: ENATType = ENATType(3)
  }
}

@JvmInline
public value class EPacketReliability(
  public val `value`: Int,
) {
  public companion object {
    public val UnreliableUnordered: EPacketReliability = EPacketReliability(0)

    public val ReliableUnordered: EPacketReliability = EPacketReliability(1)

    public val ReliableOrdered: EPacketReliability = EPacketReliability(2)
  }
}

@JvmInline
public value class EConnectionEstablishedType(
  public val `value`: Int,
) {
  public companion object {
    public val NewConnection: EConnectionEstablishedType = EConnectionEstablishedType(0)

    public val Reconnection: EConnectionEstablishedType = EConnectionEstablishedType(1)
  }
}

@JvmInline
public value class ENetworkConnectionType(
  public val `value`: Int,
) {
  public companion object {
    public val NoConnection: ENetworkConnectionType = ENetworkConnectionType(0)

    public val DirectConnection: ENetworkConnectionType = ENetworkConnectionType(1)

    public val RelayedConnection: ENetworkConnectionType = ENetworkConnectionType(2)
  }
}

@JvmInline
public value class EConnectionClosedReason(
  public val `value`: Int,
) {
  public companion object {
    public val Unknown: EConnectionClosedReason = EConnectionClosedReason(0)

    public val ClosedByLocalUser: EConnectionClosedReason = EConnectionClosedReason(1)

    public val ClosedByPeer: EConnectionClosedReason = EConnectionClosedReason(2)

    public val TimedOut: EConnectionClosedReason = EConnectionClosedReason(3)

    public val TooManyConnections: EConnectionClosedReason = EConnectionClosedReason(4)

    public val InvalidMessage: EConnectionClosedReason = EConnectionClosedReason(5)

    public val InvalidData: EConnectionClosedReason = EConnectionClosedReason(6)

    public val ConnectionFailed: EConnectionClosedReason = EConnectionClosedReason(7)

    public val ConnectionClosed: EConnectionClosedReason = EConnectionClosedReason(8)

    public val NegotiationFailed: EConnectionClosedReason = EConnectionClosedReason(9)

    public val UnexpectedError: EConnectionClosedReason = EConnectionClosedReason(10)

    public val ConnectionIgnored: EConnectionClosedReason = EConnectionClosedReason(11)
  }
}

@JvmInline
public value class ERelayControl(
  public val `value`: Int,
) {
  public companion object {
    public val NoRelays: ERelayControl = ERelayControl(0)

    public val AllowRelays: ERelayControl = ERelayControl(1)

    public val ForceRelays: ERelayControl = ERelayControl(2)
  }
}

@JvmInline
public value class PlayerDataStorageEReadResult(
  public val `value`: Int,
) {
  public companion object {
    public val ContinueReading: PlayerDataStorageEReadResult = PlayerDataStorageEReadResult(1)

    public val FailRequest: PlayerDataStorageEReadResult = PlayerDataStorageEReadResult(2)

    public val CancelRequest: PlayerDataStorageEReadResult = PlayerDataStorageEReadResult(3)
  }
}

@JvmInline
public value class PlayerDataStorageEWriteResult(
  public val `value`: Int,
) {
  public companion object {
    public val ContinueWriting: PlayerDataStorageEWriteResult = PlayerDataStorageEWriteResult(1)

    public val CompleteRequest: PlayerDataStorageEWriteResult = PlayerDataStorageEWriteResult(2)

    public val FailRequest: PlayerDataStorageEWriteResult = PlayerDataStorageEWriteResult(3)

    public val CancelRequest: PlayerDataStorageEWriteResult = PlayerDataStorageEWriteResult(4)
  }
}

@JvmInline
public value class EPresenceModificationTemplateType(
  public val `value`: Int,
) {
  public companion object {
    public val INT: EPresenceModificationTemplateType = EPresenceModificationTemplateType(1)

    public val STRING: EPresenceModificationTemplateType = EPresenceModificationTemplateType(2)
  }
}

@JvmInline
public value class PresenceEStatus(
  public val `value`: Int,
) {
  public companion object {
    public val Offline: PresenceEStatus = PresenceEStatus(0)

    public val Online: PresenceEStatus = PresenceEStatus(1)

    public val Away: PresenceEStatus = PresenceEStatus(2)

    public val ExtendedAway: PresenceEStatus = PresenceEStatus(3)

    public val DoNotDisturb: PresenceEStatus = PresenceEStatus(4)
  }
}

@JvmInline
public value class EPlayerReportsCategory(
  public val `value`: Int,
) {
  public companion object {
    public val Invalid: EPlayerReportsCategory = EPlayerReportsCategory(0)

    public val Cheating: EPlayerReportsCategory = EPlayerReportsCategory(1)

    public val Exploiting: EPlayerReportsCategory = EPlayerReportsCategory(2)

    public val OffensiveProfile: EPlayerReportsCategory = EPlayerReportsCategory(3)

    public val VerbalAbuse: EPlayerReportsCategory = EPlayerReportsCategory(4)

    public val Scamming: EPlayerReportsCategory = EPlayerReportsCategory(5)

    public val Spamming: EPlayerReportsCategory = EPlayerReportsCategory(6)

    public val Other: EPlayerReportsCategory = EPlayerReportsCategory(7)
  }
}

@JvmInline
public value class ERTCAudioStatus(
  public val `value`: Int,
) {
  public companion object {
    public val Unsupported: ERTCAudioStatus = ERTCAudioStatus(0)

    public val Enabled: ERTCAudioStatus = ERTCAudioStatus(1)

    public val Disabled: ERTCAudioStatus = ERTCAudioStatus(2)

    public val AdminDisabled: ERTCAudioStatus = ERTCAudioStatus(3)

    public val NotListeningDisabled: ERTCAudioStatus = ERTCAudioStatus(4)
  }
}

@JvmInline
public value class ERTCAudioInputStatus(
  public val `value`: Int,
) {
  public companion object {
    public val Idle: ERTCAudioInputStatus = ERTCAudioInputStatus(0)

    public val Recording: ERTCAudioInputStatus = ERTCAudioInputStatus(1)

    public val RecordingSilent: ERTCAudioInputStatus = ERTCAudioInputStatus(2)

    public val RecordingDisconnected: ERTCAudioInputStatus = ERTCAudioInputStatus(3)

    public val Failed: ERTCAudioInputStatus = ERTCAudioInputStatus(4)
  }
}

@JvmInline
public value class ERTCAudioOutputStatus(
  public val `value`: Int,
) {
  public companion object {
    public val Idle: ERTCAudioOutputStatus = ERTCAudioOutputStatus(0)

    public val Playing: ERTCAudioOutputStatus = ERTCAudioOutputStatus(1)

    public val Failed: ERTCAudioOutputStatus = ERTCAudioOutputStatus(2)
  }
}

@JvmInline
public value class ERTCDataStatus(
  public val `value`: Int,
) {
  public companion object {
    public val Unsupported: ERTCDataStatus = ERTCDataStatus(0)

    public val Enabled: ERTCDataStatus = ERTCDataStatus(1)

    public val Disabled: ERTCDataStatus = ERTCDataStatus(2)
  }
}

@JvmInline
public value class ERTCParticipantStatus(
  public val `value`: Int,
) {
  public companion object {
    public val Joined: ERTCParticipantStatus = ERTCParticipantStatus(0)

    public val Left: ERTCParticipantStatus = ERTCParticipantStatus(1)
  }
}

@JvmInline
public value class ESanctionAppealReason(
  public val `value`: Int,
) {
  public companion object {
    public val Invalid: ESanctionAppealReason = ESanctionAppealReason(0)

    public val IncorrectSanction: ESanctionAppealReason = ESanctionAppealReason(1)

    public val CompromisedAccount: ESanctionAppealReason = ESanctionAppealReason(2)

    public val UnfairPunishment: ESanctionAppealReason = ESanctionAppealReason(3)

    public val AppealForForgiveness: ESanctionAppealReason = ESanctionAppealReason(4)
  }
}

@JvmInline
public value class EOnlineSessionState(
  public val `value`: Int,
) {
  public companion object {
    public val NoSession: EOnlineSessionState = EOnlineSessionState(0)

    public val Creating: EOnlineSessionState = EOnlineSessionState(1)

    public val Pending: EOnlineSessionState = EOnlineSessionState(2)

    public val Starting: EOnlineSessionState = EOnlineSessionState(3)

    public val InProgress: EOnlineSessionState = EOnlineSessionState(4)

    public val Ending: EOnlineSessionState = EOnlineSessionState(5)

    public val Ended: EOnlineSessionState = EOnlineSessionState(6)

    public val Destroying: EOnlineSessionState = EOnlineSessionState(7)
  }
}

@JvmInline
public value class ESessionAttributeAdvertisementType(
  public val `value`: Int,
) {
  public companion object {
    public val DontAdvertise: ESessionAttributeAdvertisementType =
        ESessionAttributeAdvertisementType(0)

    public val Advertise: ESessionAttributeAdvertisementType = ESessionAttributeAdvertisementType(1)
  }
}

@JvmInline
public value class EOnlineSessionPermissionLevel(
  public val `value`: Int,
) {
  public companion object {
    public val PublicAdvertised: EOnlineSessionPermissionLevel = EOnlineSessionPermissionLevel(0)

    public val JoinViaPresence: EOnlineSessionPermissionLevel = EOnlineSessionPermissionLevel(1)

    public val InviteOnly: EOnlineSessionPermissionLevel = EOnlineSessionPermissionLevel(2)
  }
}

@JvmInline
public value class TitleStorageEReadResult(
  public val `value`: Int,
) {
  public companion object {
    public val ContinueReading: TitleStorageEReadResult = TitleStorageEReadResult(1)

    public val FailRequest: TitleStorageEReadResult = TitleStorageEReadResult(2)

    public val CancelRequest: TitleStorageEReadResult = TitleStorageEReadResult(3)
  }
}

@JvmInline
public value class ERTCBackgroundMode(
  public val `value`: Int,
) {
  public companion object {
    public val LeaveRooms: ERTCBackgroundMode = ERTCBackgroundMode(0)

    public val KeepRoomsAlive: ERTCBackgroundMode = ERTCBackgroundMode(1)
  }
}

@JvmInline
public value class EApplicationStatus(
  public val `value`: Int,
) {
  public companion object {
    public val BackgroundConstrained: EApplicationStatus = EApplicationStatus(0)

    public val BackgroundUnconstrained: EApplicationStatus = EApplicationStatus(1)

    public val BackgroundSuspended: EApplicationStatus = EApplicationStatus(2)

    public val Foreground: EApplicationStatus = EApplicationStatus(3)
  }
}

@JvmInline
public value class ENetworkStatus(
  public val `value`: Int,
) {
  public companion object {
    public val Disabled: ENetworkStatus = ENetworkStatus(0)

    public val Offline: ENetworkStatus = ENetworkStatus(1)

    public val Online: ENetworkStatus = ENetworkStatus(2)
  }
}

@JvmInline
public value class EDesktopCrossplayStatus(
  public val `value`: Int,
) {
  public companion object {
    public val OK: EDesktopCrossplayStatus = EDesktopCrossplayStatus(0)

    public val ApplicationNotBootstrapped: EDesktopCrossplayStatus = EDesktopCrossplayStatus(1)

    public val ServiceNotInstalled: EDesktopCrossplayStatus = EDesktopCrossplayStatus(2)

    public val ServiceStartFailed: EDesktopCrossplayStatus = EDesktopCrossplayStatus(3)

    public val ServiceNotRunning: EDesktopCrossplayStatus = EDesktopCrossplayStatus(4)

    public val OverlayDisabled: EDesktopCrossplayStatus = EDesktopCrossplayStatus(5)

    public val OverlayNotInstalled: EDesktopCrossplayStatus = EDesktopCrossplayStatus(6)

    public val OverlayTrustCheckFailed: EDesktopCrossplayStatus = EDesktopCrossplayStatus(7)

    public val OverlayLoadFailed: EDesktopCrossplayStatus = EDesktopCrossplayStatus(8)
  }
}

@JvmInline
public value class UIENotificationLocation(
  public val `value`: Int,
) {
  public companion object {
    public val TopLeft: UIENotificationLocation = UIENotificationLocation(1)

    public val TopRight: UIENotificationLocation = UIENotificationLocation(1)

    public val BottomLeft: UIENotificationLocation = UIENotificationLocation(1)

    public val BottomRight: UIENotificationLocation = UIENotificationLocation(1)
  }
}

@JvmInline
public value class UIEOnScreenKeyboardBehavior(
  public val `value`: Int,
) {
  public companion object {
    public val None: UIEOnScreenKeyboardBehavior = UIEOnScreenKeyboardBehavior(0)

    public val Notification: UIEOnScreenKeyboardBehavior = UIEOnScreenKeyboardBehavior(1)

    public val Native: UIEOnScreenKeyboardBehavior = UIEOnScreenKeyboardBehavior(2)
  }
}

@JvmInline
public value class UIEOnScreenKeyboardType(
  public val `value`: Int,
) {
  public companion object {
    public val None: UIEOnScreenKeyboardType = UIEOnScreenKeyboardType(0)

    public val Default: UIEOnScreenKeyboardType = UIEOnScreenKeyboardType(1)

    public val Text: UIEOnScreenKeyboardType = UIEOnScreenKeyboardType(2)

    public val TelephoneNumber: UIEOnScreenKeyboardType = UIEOnScreenKeyboardType(3)

    public val URL: UIEOnScreenKeyboardType = UIEOnScreenKeyboardType(4)

    public val Email: UIEOnScreenKeyboardType = UIEOnScreenKeyboardType(5)

    public val Numeric: UIEOnScreenKeyboardType = UIEOnScreenKeyboardType(6)

    public val Decimal: UIEOnScreenKeyboardType = UIEOnScreenKeyboardType(7)

    public val Search: UIEOnScreenKeyboardType = UIEOnScreenKeyboardType(8)
  }
}
