import React from 'react';
import { Box, VStack, Image } from '@chakra-ui/react';
import { motion } from 'framer-motion';

// Convert Chakra UI Box to a motion component
const MotionBox = motion(Box);

// Define your animation variants
const variants = {
    hidden: { scale: 0.8, opacity: 0 }, // Start scaled down and with opacity 0
    visible: { scale: 1, opacity: 1 }   // Scale up to normal size and opacity 1
};

const variants2 = {
    hidden: { y: -100, opacity: 0 }, // Start 20px above and with opacity 0
    visible: { y: 0, opacity: 1 }   // End at original position with opacity 1
};

export const LeftSide = () => {
    return (
        <>
            <VStack
                display="flex"
                margin="2em"
            >
                <MotionBox
                    initial="hidden"
                    animate="visible"
                    variants={variants2}
                    transition={{
                        type: "spring", // Use a spring transition for bounce
                        stiffness: 40, // Stiffness of the spring
                        damping: 5     // How much the spring effect is dampened
                    }}
                >
                    <Box
                        maxW="15vw"
                        mb="1em"
                        borderRadius="2xl"
                        overflow="hidden"
                        boxShadow="0px 10px 20px rgba(0, 0, 0, 0.50)"
                        display="flex" 
                        alignItems="center"        // Center content vertically
                        justifyContent="center"
                    >
                        <Image 
                            src="https://u-static.fotor.com/images/text-to-image/result/PRO-652acf12f2e64c5e96d2cd2ab751dd0d.jpg" 
                            alt="App Preview" 
                            objectFit="contain"
                        />
                    </Box>
                    <Box
                        maxW="15vw"
                        maxH="35vh"
                        mb="1em"
                        borderRadius="2xl"
                        overflow="hidden"
                        boxShadow="0px 10px 20px rgba(0, 0, 0, 0.50)"
                    >
                        <Image 
                            src="https://u-static.fotor.com/images/text-to-image/result/PRO-652acf12f2e64c5e96d2cd2ab751dd0d.jpg" 
                            alt="App Preview" 
                            objectFit="cover" 
                            maxH="100%"                // Max height to 100% of the container
                            maxW="100%" 
                        />
                    </Box>
                </MotionBox>
                <Box>
                    {/* Other content */}
                </Box>
            </VStack>
        </>
    );
}
