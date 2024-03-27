import { Pressable, StyleSheet } from "react-native";
import { useAuth0 } from "react-native-auth0";

import { Text, View } from "@/app/components/Themed";

export default function ProfileScreen() {
    const { authorize, clearSession, user, error, getCredentials } = useAuth0();

    const onPress = async () => {
        try {
            if (user) {
                await clearSession();
            } else {
                await authorize({
                    audience: "https://dreamscore/api",
                });

                // @ts-ignore
                const accessToken = (await getCredentials()).accessToken;
                console.log(accessToken);

                // Now you can use this token to make your API call
            }
        } catch (e) {
            console.log(e);
        }
    };

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Profile</Text>
            <View style={styles.separator} lightColor="#eee" darkColor="rgba(255,255,255,0.1)" />
            {user && (
                <>
                    <Text>Logged in as {user.name}</Text>
                    <Text>{user.sub?.split("|")[1]}</Text>
                </>
            )}
            {error && <Text>{error.message}</Text>}
            <Pressable onPress={onPress}>
                <Text>{user ? "Log out" : "Log in"}</Text>
            </Pressable>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: "center",
        justifyContent: "center",
    },
    title: {
        fontSize: 20,
        fontWeight: "bold",
    },
    separator: {
        marginVertical: 30,
        height: 1,
        width: "80%",
    },
});
