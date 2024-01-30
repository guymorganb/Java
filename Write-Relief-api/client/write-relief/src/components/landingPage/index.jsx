import React, {useState} from "react";
import {Box, VStack, HStack, Flex, Image} from "@chakra-ui/react";
import { LeftSide } from "./leftSide";
import { Middle } from "./center";

export const LandingPage = () => {

    return(
        <>
        <Flex>
            <HStack>
                <Box>
                    <LeftSide />
                </Box>
                <Box>
                    <Middle/>
                </Box>
            </HStack>
        </Flex>
        </>
    )

}