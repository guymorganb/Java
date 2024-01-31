import React from 'react';
import { Box, Text, Link, VStack, Heading, Icon, ListItem, List } from '@chakra-ui/react';
import { TbClick } from "react-icons/tb"; // Import an appropriate icon
import { motion } from 'framer-motion';
import { IconStyle } from '../../assets/custom_css_svgs/iconStyles.jsx';
import { CustomTooltip } from '../../assets/custom_css_svgs/customeTooltip.jsx';
import {TypewriterText} from '../../assets/custom_css_svgs/typewriter.jsx';

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
        <MotionBox
            initial="hidden"
            animate="visible"
            variants={variants}
            transition={{
                type: "spring",
                stiffness: 40,
                damping: 4
            }}
            boxShadow="0 10px 10px rgba(0, 0, 0, 0.4)"
            width="fit-content" // Equivalent to w-full
            display="flex"// Equivalent to xl:flex
            justifyContent="left"
            m="28"
            p="2"
            overflowY="hidden"
            borderWidth="2px" // Set the initial border width
            borderColor="gray.200" // Set the initial border color
            borderRadius="10%"
            _hover={{
                borderColor: "blue.500", // Change border color on hover
            }}
            _active={{
                borderColor: "green.500", // Change border color when active/clicked
            }}
            _focus={{
                borderColor: "red.500", // Change border color when focused
                boxShadow: "0 0 0 3px rgba(66, 153, 225, 0.6)", // Optional: add a box-shadow or other styles on focus for accessibility
            }}
        >
            <VStack spacing={4} textAlign={{ base: "center", md: "left" }}>
                <Heading
                    fontSize={{ base: "3xl", md: "5xl" }}
                    color="purple.800"
                    fontWeight="bold"
                    my={3}
                >
                    Write Relief 📝
                </Heading>
                <TypewriterText>

                   <strong><i>"Write hard and clear about what hurts."</i></strong> - Ernest Hemingway
                
                </TypewriterText>
                <Link
                    href="/notes"
                    color="blue.300"
                    _hover={{ color: "indigo.800", textDecoration: "underline" }}
                    p={2}
                    display="inline-block"
                    verticalAlign="middle"
                >
                    <List className="wrapper" display="flex" listStyleType="none">
                        <ListItem  className="icon document" {...IconStyle}>
                            <CustomTooltip as='span'>Checkout the app</CustomTooltip>
                            <Box as='span' fontSize={48}><TbClick /></Box>
                        </ListItem>
                    </List>
                   
                </Link>
            </VStack>
        </MotionBox>
    );
}
