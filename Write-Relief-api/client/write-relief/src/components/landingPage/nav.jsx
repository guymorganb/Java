import React, { useRef, useEffect } from 'react';
import gsap from 'gsap';
import { MotionPathPlugin } from 'gsap/MotionPathPlugin';
import { Box, VStack, List, ListItem, Link, chakra, Text } from '@chakra-ui/react';
import { motion } from 'framer-motion';
import { IconStyle } from '../../assets/custom_css_svgs/iconStyles.jsx';
import { CustomTooltip } from '../../assets/custom_css_svgs/customeTooltip.jsx';
import { CustomUnderline_middle_to_Edges } from '../../assets/custom_css_svgs/customUnderline.jsx';
import {SvgPath} from '../../assets/util/svgPath.jsx';
import {AdditionalPathD} from '../../assets/util/svgPath.jsx';
import { FaInstagram, FaGithub } from 'react-icons/fa';
import { keyframes } from 'styled-components';
// Convert Chakra UI Box to a motion component
const MotionBox = motion(Box);

// gsap animation
gsap.registerPlugin(MotionPathPlugin);

// SVG border width
const width = 600; // Adjust this to match the actual width of your navbar
const height = 175;
const pencilEmoji = '✏️';

// responsive styles for the nav things
let pencilLeft ={base: '1.5rem', sm: '1.5rem', md: '1.5rem', lg: '1.5rem', xl: '1.5rem', '2xl': '1.5rem' }
let pencilTop ={base: '1.5rem', sm: '1.5rem', md: '1.5rem', lg: '1.5rem', xl: '1.5rem', '2xl': '1.5rem' }
let svgLeft = {base: '1.5rem', sm: '1.5rem', md: '1.5rem', lg: '1.5rem', xl: '1.5rem', '2xl': '1.5rem' }
let svgTop = {base: '1.5rem', sm: '1.5rem', md: '1.5rem', lg: '1.5rem', xl: '1.5rem', '2xl': '1.5rem' }

// Define your animation variants
const variants2 = {
    hidden: { y: -100, opacity: 0 }, // Start 20px above and with opacity 0
    visible: { y: 0, opacity: 1 }   // End at original position with opacity 1
};
// Begin component
export const Nav = () => {
    const pencilRef = useRef(null);
    const additionalPathRef = useRef(null);
    // controls the fade in for the drawing
    const fadeIn = `@keyframes fadeIn {
        10%{
            opacity:.1
        }
        20%{
            opacity:.2
        }
        30%{
            opacity:.3
        }
        40%{
            opacity:.4
        }
        50%{
            opacity:.5
        }
        60%{
            opacity:.6
        }
        70%{
            opacity:.7
        }
        80%{
            opacity:.8
        }
        90%{
            opacity:.9
        }
        100%{
            opacity:1
        }`;
    // controlls the pencil and the line the pencil draws
    useEffect(() => {
        const additionalPath = additionalPathRef.current;

        // For the additional path
        const additionalPathLength = additionalPath.getTotalLength();
        gsap.set(additionalPath, {
            strokeDasharray: additionalPathLength,
            strokeDashoffset: additionalPathLength,
        });
    
        // Animate the drawing of both lines
        gsap.to([additionalPath], {
            strokeDashoffset: 0,
            duration: 5,
            ease: "power1.inOut",
        });

        // Animate the pencil emoji along the path
        gsap.to(pencilRef.current, {
            duration: 5,
            ease: "power1.inOut",
            motionPath: {
                path: additionalPath,
                alignOrigin: [0, 0],
                autoRotate: false
            }
        });
    }, []);

    return (
    // Motion/Animation
    <MotionBox
            initial="hidden"
            animate="visible"
            variants={variants2}
            transition={{
                type: "spring", // Use a spring transition for bounce
                stiffness: 40, // Stiffness of the spring
                damping: 4     // How much the spring effect is dampened
                
            }}
        >
        <Box position="relative" className="w-full flex flex-row justify-center items-center mx-auto rounded-lg shadow-lg"> {/* Relative Container */}
            <Box as='svg' position="absolute" top="0" left="0" width="100%" height={`${height}px`} viewBox={`350 50 ${width} ${height}`} >
                <defs>
                    <radialGradient id="radialGradient" cx="50%" cy="50%" r="50%" fx="50%" fy="50%" >
                        <stop offset="0%" style={{ stopColor: "#228b22", stopOpacity: 1 }} />
                        <stop offset="100%" style={{ stopColor: "#FFFFFF", stopOpacity: 1 }} />
                    </radialGradient>
                </defs>
                    <path ref={additionalPathRef} d={AdditionalPathD} stroke="gray" fill="url(#radialGradient)" fillRule="nonzero" style={{ opacity: 0, animation: 'fadeIn 3.5s forwards' }}/>
            </Box>
            
            <Box ref={pencilRef} as="span" position="absolute" left="-135px" top="-73px" fontSize="20px" zIndex="2">
                {pencilEmoji}
            </Box>
            <Box className="w-full container mx-auto pt-9 ">
                <Box className="w-full flex items-center justify-between">
                    <Link className="flex items-center text-indigo-400 no-underline hover:no-underline font-bold text-2xl lg:text-4xl"  href="#" style={{ textDecoration: 'none' }} >
                        <svg className="h-8 fill-current text-indigo-600 pr-2" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M11 9c1.361-5.928 8-7 8-7v-2l4 3.982-4 4.018v-2s-5.102-.104-8 3zm5 1h-10v1h10v-1zm3 .835v2.708c0 4.107-6 2.457-6 2.457s1.518 6-2.638 6h-7.362v-20h10.741c1.176-.758 2.35-1.242 3.259-1.541v-.459h-16v24h10.189c3.163 0 9.811-7.223 9.811-9.614v-5.561l-2 2.01zm-13 3.165h10v-1h-10v1zm3.609-7h-3.609v1h3.266l.343-1z"/></svg>
                        <CustomUnderline_middle_to_Edges>
                            <Text className='WR' boxShadow="0 10px 10px rgba(0, 0, 0, 0.4)" borderRadius="10%">Write Relief</Text> 
                        </CustomUnderline_middle_to_Edges>
                    </Link>
                    <Box>
                    <Box>
                        {/* Icons */}
                        <List className="wrapper" display="inline-flex" listStyleType="none" >
                            <ListItem className="icon instagram" {...IconStyle}>
                                <CustomTooltip as='span'>Instagram</CustomTooltip>
                                <Box as='span' ><FaInstagram /></Box>
                            </ListItem>
                            <ListItem className="icon github" {...IconStyle}>
                                <CustomTooltip as='span'>Github</CustomTooltip>
                                <Box as='span'><FaGithub /></Box>
                            </ListItem>
                        </List>
                    </Box>
               
                    </Box>
                    </Box>
            </Box>
            <style>{fadeIn}</style>
        </Box>
    </MotionBox> 
    );
}
