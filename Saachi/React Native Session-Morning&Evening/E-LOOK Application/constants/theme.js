import { Dimensions } from "react-native";
const { width, height } = Dimensions.get("window");

export const COLORS = {
    black: "#1E1B26",
    white: "#FFFFFF",
};

export const SIZES = {
    
    base: 8,
    font: 14,
    radius: 12,
    padding: 24,
    padding2: 36,
    largeTitle: 50,
    h1: 30,
    h2: 22,
    h3: 16,
    h4: 14,
    body1: 30,
    body2: 20,
    body3: 16,
    body4: 14,
    width,
    height
};

export const FONTS = {
    largeTitle: { fontFamily: "Roboto", fontSize: SIZES.largeTitle, lineHeight: 55 },
    h1: { fontFamily: "Roboto", fontSize: SIZES.h1, lineHeight: 36 },
    h2: { fontFamily: "Roboto", fontSize: SIZES.h2, lineHeight: 30 },
    h3: { fontFamily: "Roboto", fontSize: SIZES.h3, lineHeight: 22 },
    h4: { fontFamily: "Roboto", fontSize: SIZES.h4, lineHeight: 22 },
    body1: { fontFamily: "Roboto", fontSize: SIZES.body1, lineHeight: 36 },
    body2: { fontFamily: "Roboto", fontSize: SIZES.body2, lineHeight: 30 },
    body3: { fontFamily: "Roboto", fontSize: SIZES.body3, lineHeight: 22 },
    body4: { fontFamily: "Roboto", fontSize: SIZES.body4, lineHeight: 22 },
};

const appTheme = { COLORS, SIZES, FONTS };

export default appTheme;