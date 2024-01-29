import React, {useState} from "react";
import {Box, VStack, HStack, Flex, Image} from "@chakra-ui/react";
import { motion } from "framer-motion";
// Convert Chakra UI Box to a motion component
const MotionBox = motion(Box);

export const LandingPage = () => {

    return(
        <>
        <Box>
            <HStack>
                <VStack>
                <MotionBox
                        maxW="100px"
                        borderRadius="2xl"
                        overflow="hidden"
                        boxShadow="xl"
                        initial="hidden"
                        animate="visible"
                        
                        transition={{ duration: 0.5 }}
                        // Additional styling
                        >
                        <Image 
                            src="https://u-static.fotor.com/images/text-to-image/result/PRO-652acf12f2e64c5e96d2cd2ab751dd0d.jpg" 
                            alt="App Preview" 
                            objectFit="cover" 
                        />

                    </MotionBox>

                    <Box>

                    </Box>
                </VStack>
                <Box>
                    <VStack>
                        <Box>

                        </Box>

                        <Box>

                        </Box>
                    </VStack>
                </Box>
                <VStack>
                    <Box>

                    </Box>

                    <Box>

                    </Box>
                </VStack>
            </HStack>
        </Box>
        </>
    )

}